package czhy.component.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.MDC;

import java.io.IOException;
import java.util.UUID;

public class TraceIdFilter implements Filter {

    private static final String TRACE_ID_HEADER = "X-Trace-Id";
    private static final String TRACE_ID_KEY = "traceId";

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        try {
            // 尝试从 HTTP 头中获取 traceId
            String traceId = ((HttpServletRequest) request).getHeader(TRACE_ID_HEADER);
            if (traceId == null) {
                // 如果没有 traceId，则生成一个新的
                traceId = UUID.randomUUID().toString();
            }
            // 将 traceId 放入 MDC 中
            MDC.put(TRACE_ID_KEY, traceId);

            chain.doFilter(request, response);
        } finally {
            // 清除 MDC 中的 traceId，以避免内存泄漏
            MDC.remove(TRACE_ID_KEY);
        }
    }
}
