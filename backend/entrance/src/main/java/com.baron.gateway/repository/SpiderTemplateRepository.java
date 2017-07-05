package com.baron.gateway.repository;

import com.baron.gateway.model.SpiderTemplate;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.Repository;
import org.springframework.stereotype.Component;

/**
 * Created by Jason on 2017/6/13.
 */
public interface SpiderTemplateRepository extends MongoRepository<SpiderTemplate, String> {
    SpiderTemplate findById(String id);
}
