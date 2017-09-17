package com.baron.entrance.dao;

import com.baron.entrance.model.SpiderTask;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by Jason on 2017/6/13.
 */
public interface SpiderTaskDao extends MongoRepository<SpiderTask, String> {
    SpiderTask findById(String id);
}
