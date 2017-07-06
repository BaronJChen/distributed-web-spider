package com.baron.entrance.program;

import com.baron.entrance.util.LogUtil;
import org.apache.log4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * Created by Jason on 2017/5/31.
 */
@EnableEurekaClient
@SpringBootApplication
@ComponentScan("com.baron")
@EnableMongoRepositories("com.baron")
public class EntranceApplication {
    public static void main(String [] args) {
        SpringApplication.run(EntranceApplication.class, args);
    }
}