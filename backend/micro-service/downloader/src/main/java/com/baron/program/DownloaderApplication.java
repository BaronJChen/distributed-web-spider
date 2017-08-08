package com.baron.program;

import com.baron.common.annotation.SpiderApplication;
import org.springframework.boot.SpringApplication;

@SpiderApplication
public class DownloaderApplication {
    public static void main(String[] args) {
        SpringApplication.run(DownloaderApplication.class, args);
    }
}
