package com.baron.common.program;

import com.baron.common.model.SpiderTaskLog;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Description:
 *
 * @author Jason
 * @date 2017/9/13 22:21
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = AppConfiguration.class)
public class BeanInitializerTest {
    @Autowired
    private MongoTemplate mongoTemplate;

    @Test
    public void mongoTemplate() {
        List object = mongoTemplate.findAll(SpiderTaskLog.class);
        System.out.println(object.get(0));
    }
}
