package czhy.dto.user;

import czhy.model.UserModel;
import lombok.Data;

import java.util.List;


@Data
public class UserResDto {

    @Data
    public static class Create {
        private Integer id;
        private String email;
        private String name;
    }

    @Data
    public static class Detail {
        private Integer id;
        private String email;
        private String name;
    }

    @Data
    public static class ItemList {
        private Integer id;
        private String email;
        private String name;
    }

    @Data
    public static class PageList {
        private List<ItemList> list;
        private Long total;
    }

    //处理分页数据
    public static List<ItemList> Of(List<UserModel> m) {
        return m.stream().map(user -> {
            ItemList item = new ItemList();
            item.setId(user.getId());
            item.setEmail(user.getEmail());
            item.setName(user.getName());
            return item;
        }).toList();
    }

}


