package czhy.errorCode.user;

import lombok.Getter;

@Getter
public enum UserErrCode {

    USER_NOT_EXIST(1001, "用户不存在"),
    INVALID_REQUEST(1002, "请求无效"),
    UNAUTHORIZED(1003, "未授权的访问");

    private final int code;
    private final String message;

    UserErrCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

}
