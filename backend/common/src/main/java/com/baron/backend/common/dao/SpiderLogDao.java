package com.baron.backend.common.dao;

import com.baron.backend.common.model.SpiderLog;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Description:
 *
 * @author Jason
 * @date 2017/9/16 12:46
 */

public interface SpiderLogDao extends MongoRepository<SpiderLog, String> {
}
