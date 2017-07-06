package com.baron.bootstrap.program;

import com.baron.common.annotation.ForLocalTest;
import com.braon.program.ZuulApplication;
import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.util.FileCopyUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
    public static void main(String[] args) throws IOException, InterruptedException {
        Class[] classes = new Class[] {
                EurekaApplication.class,
                ZuulApplication.class,
                FrontendApplication.class
        };
        String[] fileNames = new String[] {
                "application.yaml",
                "application.yaml",
                "application.yaml"
        };
        int length = classes.length;
        List<Thread> startupThreads = new ArrayList<>();

        for (int i = 0; i < length; ++i) {
            final int count = i;

            Thread startupThread = new Thread(() -> {
                SpringApplication.run(classes[count], "--spring.jmx.default-domain=${random.uuid}");

            });

            startupThread.setPriority(Thread.MAX_PRIORITY);
            startupThread.start();
            startupThreads.add(startupThread);
            Thread.currentThread().sleep(100000);

            File file = new File(classes[count].getClassLoader().getResource(fileNames[count]).getPath());
            try {
                FileCopyUtils.copy(file, new File(file.getPath() + "_backup" + count));
            } catch (IOException e) {
                LOG.error(e);
                System.exit(-1);
            } // catch

            file.delete();
        } // for

        for (Thread startupThread : startupThreads) {
            startupThread.join();
        } // for

        for (int i = 0; i < length; ++i)  {
            File file = new File(classes[i].getClassLoader().getResource(fileNames[i] + "_backup" + i).getPath());
            FileCopyUtils.copy(file, new File(file.getPath().substring(0, file.getPath().length() - 8)));
            file.delete();
        } // for
    }
}
