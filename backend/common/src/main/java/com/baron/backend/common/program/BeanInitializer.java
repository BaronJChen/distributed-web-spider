package com.baron.backend.common.program;

import com.baron.backend.common.property.MongoProperty;
import com.baron.backend.common.property.RedisProperty;
import com.mongodb.MongoClient;
import com.mongodb.ServerAddress;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

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

    @Bean
    public JedisConnectionFactory jedisConnectionFactory(RedisProperty redisProperty) {
        JedisConnectionFactory jedisConnectionFactory = new JedisConnectionFactory();

        jedisConnectionFactory.setDatabase(redisProperty.getDb());
        jedisConnectionFactory.setHostName(redisProperty.getHost());
        jedisConnectionFactory.setPort(redisProperty.getPort());
        jedisConnectionFactory.setTimeout(redisProperty.getTimeout());
        jedisConnectionFactory.setPassword(redisProperty.getPassword());

        return jedisConnectionFactory;
    }
}
