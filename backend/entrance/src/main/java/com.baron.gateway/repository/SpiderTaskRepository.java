package com.baron.gateway.repository;

import com.baron.gateway.model.SpiderTask;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.Repository;
import org.springframework.stereotype.Component;

/**
 * Created by Jason on 2017/6/13.
 */
public interface SpiderTaskRepository extends MongoRepository<SpiderTask, String> {
    SpiderTask findById(String id);
}
