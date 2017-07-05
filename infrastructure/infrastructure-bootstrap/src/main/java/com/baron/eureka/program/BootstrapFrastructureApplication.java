package com.baron.eureka.program;

import com.baron.common.annotation.ForLocalTest;
import com.braon.program.ZuulApplication;
import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;

import java.io.File;
import java.io.IOException;

/**
 * Created by Administrator on 2017/7/4 0004.
 */
@ForLocalTest
public class BootstrapFrastructureApplication {
    private static final Logger LOG = Logger.getLogger(BootstrapFrastructureApplication.class);

    /**
     * start multiple spring boot applications in one jvm
     * In usual, spring boot application will need to read a configuration file when it starts
     * so this will lead to multiple applications read the same configuration file
     * because of the spring's file location mechanism
     * Enventually, I came up with a solution.
     * 1、when we start an application, rename its configuration file
     * 2、after we started all applications, rename them back.
     *
     * Also, we may come across the problem that jxm beans' name can't be same,
     * so we need to add '--spring.jmx.default-domain=${random.uuid}' as an argument.
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        Class[] classes = new Class[] {
                EurekaApplication.class,
                ZuulApplication.class
        };
        String[] files = new String[] {
                "application.yaml",
                "application.yaml"
        };
        int length = classes.length;

        for (int i = 0; i < length; ++i) {
            File file = new File(classes[i].getClassLoader().getResource(files[i]).getPath());
            if (!file.exists()) {
                LOG.error("profile not exists");
                System.exit(-1);
            } // if
            SpringApplication.run(classes[i], "--spring.jmx.default-domain=${random.uuid}");
            file.renameTo(new File(file.getPath() + "_backup" + i));
        } // for

        for (int i = 0; i < length; ++i)  {
            File file = new File(classes[i].getClassLoader().getResource(files[i] + "_backup" + i).getPath());
            file.renameTo(new File(file.getPath().substring(0, file.getPath().length() - 8)));
        }
    }
}
