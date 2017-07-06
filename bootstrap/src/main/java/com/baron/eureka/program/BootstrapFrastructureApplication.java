package com.baron.eureka.program;

import com.baron.common.annotation.ForLocalTest;
import com.baron.common.util.StringUtil;
import com.baron.frontend.program.FrontendApplication;
import com.baron.entrance.program.EntranceApplication;
import com.braon.program.ZuulApplication;
import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;

/**
 * Created by Administrator on 2017/7/4 0004.
 */
@ForLocalTest
public class BootstrapFrastructureApplication {
    private static final Logger LOG = Logger.getLogger(BootstrapFrastructureApplication.class);

    public static void main(String[] args) throws InterruptedException {
        Class[] classes = new Class[]{
                EurekaApplication.class,
                ZuulApplication.class,
                FrontendApplication.class,
                EntranceApplication.class
        };
        String[][] argumentLists = new String[4][];
        argumentLists[0] = new String[]{ "--spring.profiles.active=eureka" };
        argumentLists[1] = new String[]{ "--spring.profiles.active=zuul" };
        argumentLists[2] = new String[]{ "--spring.profiles.active=frontend" };
        argumentLists[3] = new String[]{ "--spring.profiles.active=entrance" };
        final String[] arguments = new String[]{"--spring.jmx.default-domain=${random.uuid}"};
        int length = classes.length;

        for (int i = 0; i < length; ++i) {
            final int count = i;
            new Thread(() -> {
                SpringApplication.run(classes[count], StringUtil.concat(arguments, argumentLists[count]));
            }).start();
            Thread.currentThread().sleep(1000);
        } // for
    }
}
