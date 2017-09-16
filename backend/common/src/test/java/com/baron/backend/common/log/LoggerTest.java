package com.baron.backend.common.log;

import com.baron.backend.common.dao.SpiderLogDao;
import com.baron.backend.common.program.CommonConfiguration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Description:
 *
 * @author Jason
 * @date 2017/9/13 23:21
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = CommonConfiguration.class)
public class LoggerTest {
    @Autowired
    SpiderLogDao spiderLogDao;

    @Test
    public void testDoAppend() {
        SpiderLogger logger = SpiderLogger.getSpiderLogger(LoggerTest.class);
        logger.spiderError("test", new Exception());

        Object o = spiderLogDao.findAll();
        System.out.println();
    }
}