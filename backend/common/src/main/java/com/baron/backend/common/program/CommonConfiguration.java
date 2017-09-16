package com.baron.backend.common.program;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * Description:
 *
 * @author Jason
 * @date 2017/9/13 21:43
 */

@Configuration
@EnableConfigurationProperties
@EnableEurekaClient
@EnableMongoRepositories("com.baron")
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class CommonConfiguration {
}
