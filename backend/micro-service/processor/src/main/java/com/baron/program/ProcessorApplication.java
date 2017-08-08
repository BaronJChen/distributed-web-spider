package com.baron.program;

import com.baron.common.annotation.SpiderApplication;
import org.springframework.boot.SpringApplication;

@SpiderApplication
public class ProcessorApplication {
    public static void main(String [] args) {
        SpringApplication.run(ProcessorApplication.class, args);
    }
}
