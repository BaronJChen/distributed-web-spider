package com.braon.program;

import com.baron.common.constants.AppConstants;
import com.baron.common.util.StringUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * Created by Administrator on 2017/7/4 0004.
 */
@SpringBootApplication
@EnableZuulProxy
public class ZuulApplication {
    public static void main(String[] args){
        args = StringUtil.concat(AppConstants.PROFILE_ZUUL_ARGUMENT, args);
        SpringApplication.run(ZuulApplication.class, args);
    }
}
