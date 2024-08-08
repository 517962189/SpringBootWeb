package czhy.enums.user;

import lombok.Getter;

@Getter
public enum UserEnum {

    //用户性别 男 女 未知
    USER_GENDER_MALE(1, "男"),
    USER_GENDER_FEMALE(2, "女"),
    USER_GENDER_UNKNOWN(3, "未知");

    private final int code;
    private final String message;

    UserEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
