package com.baron.backend.common.property;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * Description:
 *
 * @author Jason
 * @date 2017/9/16 13:49
 */
@Data
@Component
@ConfigurationProperties(prefix = "redis")
@PropertySource("classpath:redis.properties")
public class RedisProperty {
    private String host;
    private Integer port;
    private String password;
    private Integer db;
    private Integer timeout;
}
