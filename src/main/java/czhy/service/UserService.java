package czhy.service;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.plugins.pagination.PageDTO;
import czhy.dto.user.UserReqDto;
import czhy.dto.user.UserResDto;
import czhy.errorCode.user.UserErrCode;
import czhy.exception.BusinessException;
import czhy.mapper.UserMapper;
import czhy.model.UserModel;
import io.micrometer.common.util.StringUtils;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Objects;

import static czhy.constants.UserConst.DEFAULT_ADMIN_NAME;

@Service
@RequiredArgsConstructor
public class UserService {

    private static final Logger log = LoggerFactory.getLogger(UserService.class);
    private final UserModel userModel;

    private final UserMapper userMapper;


    public Integer Create(UserReqDto.Create param) {
        userModel.setName(DEFAULT_ADMIN_NAME);
        userModel.setEmail(param.getEmail());
        userMapper.insert(userModel);

        return userModel.getId();
    }

    public Integer Update(UserReqDto.Update param) {
        if (Objects.equals(param.getId(), null)) {
            return null;
        }
        userModel.setName(param.getName());
        userModel.setEmail(param.getEmail());
        LambdaQueryWrapper<UserModel> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(UserModel::getId, param.getId());
        return userMapper.update(userModel, wrapper);
    }


    public UserModel Detail(UserReqDto.Detail param) {
        UserModel user = userMapper.selectById(param.getId());
        if (user == null) {

            throw new BusinessException(
                    UserErrCode.USER_NOT_EXIST.getCode(),
                    UserErrCode.USER_NOT_EXIST.getMessage());
        }

        return userMapper.selectById(param.getId());
    }


    public UserResDto.PageList List(UserReqDto.PageList param) {
        log.info("param:{}", param);
        Page<UserModel> page = new PageDTO<>(param.getPage(), param.getSize());
        LambdaQueryWrapper<UserModel> wrapper = new LambdaQueryWrapper<>();

        wrapper.like(StringUtils.isNotEmpty(param.getName()), UserModel::getName, param.getName())
                .orderByDesc(UserModel::getId); // 倒序
        Page<UserModel> pageList = userMapper.selectPage(page, wrapper);

        UserResDto.PageList paging = new UserResDto.PageList();
        paging.setTotal(pageList.getTotal());
        paging.setList(UserResDto.Of(pageList.getRecords()));
        return paging;
    }

}
