package com.baron.backend.common.property;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * Description:
 *
 * @author Jason
 * @date 2017/9/13 21:33
 */

@Data
@Component
@PropertySource("classpath:mongodb.properties")
@ConfigurationProperties(prefix = "mongodb")
public class MongoProperty {
    private String dbName;
    private String host;
    private Integer port;
}
