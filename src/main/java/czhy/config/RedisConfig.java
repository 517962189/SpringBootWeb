package czhy.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
@Service
@Data
@ConfigurationProperties(prefix = "spring.data.redis")
public class RedisConfig {
    private String host;
    private Integer port;
    private String password;
    private Integer database;
}
