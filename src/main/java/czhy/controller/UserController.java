package czhy.controller;


import czhy.component.common.ApiResponse;
import czhy.dto.user.UserReqDto;
import czhy.dto.user.UserResDto;
import czhy.model.UserModel;
import czhy.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
@Tag(name = "用户管理", description = "处理用户相关的请求")
public class UserController {


    private static final Logger log = LoggerFactory.getLogger(UserController.class);
    private final UserService userService;

    @PostMapping("/create")
    @Operation(summary = "创建用户")
    public ApiResponse<Integer> createUser(@Valid @RequestBody UserReqDto.Create param) {

        return ApiResponse.success(userService.Create(param));
    }

    @PostMapping("/update")
    @Operation(summary = "更新用户")
    public ApiResponse<Integer> updateUser(@Valid @RequestBody UserReqDto.Update param) {

        return ApiResponse.success(userService.Update(param));
    }

    @PostMapping("/detail")
    @Operation(summary = "获取用户详情")
    public ApiResponse<UserModel> detail(@Valid @RequestBody UserReqDto.Detail param) {
        return ApiResponse.success(userService.Detail(param));
    }

    @PostMapping("/getPageList")
    @Operation(summary = "获取用户列表")
    public ApiResponse<UserResDto.PageList> list(@Valid @RequestBody UserReqDto.PageList param) {
        log.info("getPageList param:{}", param);
        return ApiResponse.success(userService.List(param));
    }

}
