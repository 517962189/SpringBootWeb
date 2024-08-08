package czhy.component.common;

import lombok.Data;
import org.slf4j.MDC;


@Data
public class ApiResponse<T> {

    private int code;
    private String msg;
    private T data;
    private String traceId;


    // 成功响应的快捷方法
    public static <T> ApiResponse<T> success(T data) {
        ApiResponse<T> response = new ApiResponse<>();
        response.setCode(0); // 假设 0 代表成功
        response.setMsg("success");
        response.setData(data);
        response.setTraceId(MDC.get("traceId")); // 生成 logId
        return response;
    }

    // 错误响应的快捷方法
    public static <T> ApiResponse<T> error(int code, String msg) {
        ApiResponse<T> response = new ApiResponse<>();
        response.setCode(code);
        response.setMsg(msg);
        response.setTraceId(MDC.get("traceId")); // 生成 logId
        return response;
    }
}
