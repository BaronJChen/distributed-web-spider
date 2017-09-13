package com.baron.common.log;

import com.baron.common.program.AppConfiguration;
import com.baron.common.program.RequestContext;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * Description:
 *
 * @author Jason
 * @date 2017/9/13 23:21
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = AppConfiguration.class)
public class SpiderLogAppenderTest {
    @Test
    public void testDoAppend() {
        Logger logger = Logger.getLogger(SpiderLogAppenderTest.class);
        RequestContext.getContext().setSpiderTaskId("1234");
        logger.error("test", new Exception());
    }
}