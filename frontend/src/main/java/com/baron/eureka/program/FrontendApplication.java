package com.baron.eureka.program;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Created by Administrator on 2017/7/4 0004.
 */
@SpringBootApplication
@EnableEurekaClient
public class FrontendApplication {
    public static void main(String[] args) {
        SpringApplication.run(FrontendApplication.class);
    }
}
