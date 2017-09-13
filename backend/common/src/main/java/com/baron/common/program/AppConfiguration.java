package com.baron.common.program;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * Description:
 *
 * @author Jason
 * @date 2017/9/13 21:43
 */

@Configuration
@EnableConfigurationProperties
@ComponentScan("com.baron")
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class AppConfiguration {
}
