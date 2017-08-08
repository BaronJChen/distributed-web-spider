package com.baron.common.annotation;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@SpringBootApplication
@EnableEurekaClient
@ComponentScan("com.baron")
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface SpiderApplication {
}
