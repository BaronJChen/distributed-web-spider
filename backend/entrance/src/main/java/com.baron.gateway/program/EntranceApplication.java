package com.baron.gateway.program;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by Jason on 2017/5/31.
 */
@SpringBootApplication
@EnableEurekaClient
@ComponentScan("com.baron.**")
public class EntranceApplication {
    public static void main(String [] args) {
        SpringApplication.run(EntranceApplication.class, args);
    }
}