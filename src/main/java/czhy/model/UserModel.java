package czhy.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.springframework.stereotype.Service;

@Data
@Service
@TableName("m_user")
public class UserModel {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String name;
    private String email;
}
