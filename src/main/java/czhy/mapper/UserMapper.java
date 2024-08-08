package czhy.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import czhy.model.UserModel;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<UserModel> {

}
