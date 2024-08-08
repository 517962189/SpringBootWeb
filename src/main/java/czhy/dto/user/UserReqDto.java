package czhy.dto.user;


import io.swagger.v3.oas.annotations.Parameter;
import jakarta.validation.constraints.NotNull;
import lombok.Data;


@Data
public class UserReqDto {

    @Data
    public static class Create {
        @Parameter(description = "邮箱", required = true)
        private String email;

        @Parameter(description = "用户名", required = true)
        private String name;
    }

    @Data
    public static class Update {

        @NotNull(message = "不能为空")
        @Parameter(description = "用户ID", required = true)
        private Long id;

        @Parameter(description = "邮箱", required = true)
        private String email;

        @Parameter(description = "用户名", required = true)
        private String name;
    }

    @Data
    public static class Detail {
        @NotNull(message = "不能为空")
        @Parameter(description = "用户ID", required = true)
        private Long id;
    }

    @Data
    public static class PageList {
        private Long page;
        private Long size;
        private String name;
    }

}


