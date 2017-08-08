package com.baron.bootstrap.program;

import com.baron.common.util.StringUtil;
import com.baron.eureka.program.EurekaApplication;
import com.baron.frontend.program.FrontendApplication;
import com.braon.zuul.program.ZuulApplication;
import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;

/**
 * Created by Administrator on 2017/7/4 0004.
 */
public class BootstrapApplication {
    private static final Logger log = Logger.getLogger(BootstrapApplication.class);

    public static void main(String[] args) throws InterruptedException {
        Class[] classes = new Class[]{
                EurekaApplication.class,
                ZuulApplication.class,
                FrontendApplication.class,
        };
        String[][] argumentLists = new String[classes.length][];
        final String[] arguments = new String[]{"--spring.jmx.default-domain=${random.uuid}"};

        argumentLists[0] = new String[]{ "--spring.profiles.active=eureka" };
        argumentLists[1] = new String[]{ "--spring.profiles.active=zuul" };
        argumentLists[2] = new String[]{ "--spring.profiles.active=frontend" };

        for (int i = 0, length = classes.length; i < length; ++i) {
            final int count = i;
            new Thread(() -> {
                SpringApplication.run(classes[count], StringUtil.concat(arguments, argumentLists[count]));
            }).start();
            Thread.currentThread().sleep(1000);
        } // for
    }
}
