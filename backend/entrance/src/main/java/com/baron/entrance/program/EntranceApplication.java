package com.baron.entrance.program;

import com.baron.backend.common.annotation.SpiderApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * Created by Jason on 2017/5/31.
 */
@SpiderApplication
public class EntranceApplication {
    public static void main(String [] args) {
        SpringApplication.run(EntranceApplication.class, args);
    }
}