package com.baron.common.program;

import com.baron.common.property.MongoProperty;
import com.mongodb.MongoClient;
import com.mongodb.ServerAddress;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

/**
 * Description:
 *
 * @author Jason
 * @date 2017/9/13 21:51
 */
@Configuration
public class BeanInitializer {
    @Bean
    public MongoTemplate mongoTemplate(MongoProperty mongoProperty) {
        ServerAddress serverAddress = new ServerAddress(mongoProperty.getHost(), mongoProperty.getPort());
        MongoClient mongoClient = new MongoClient(serverAddress);
        return new MongoTemplate(mongoClient, mongoProperty.getDbName());
    }
}
