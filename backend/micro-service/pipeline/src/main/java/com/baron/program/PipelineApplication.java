package com.baron.program;

import com.baron.common.annotation.SpiderApplication;
import org.springframework.boot.SpringApplication;

@SpiderApplication
public class PipelineApplication {
    public static void main(String[] args) {
        SpringApplication.run(PipelineApplication.class, args);
    }
}
