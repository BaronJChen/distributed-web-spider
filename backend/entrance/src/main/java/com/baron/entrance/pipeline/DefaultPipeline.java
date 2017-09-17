package com.baron.entrance.pipeline;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;
import com.baron.backend.common.webmagic.ResultItems;
import com.baron.backend.common.webmagic.Task;
import com.baron.backend.common.webmagic.pipeline.Pipeline;

/**
 * Created by Jason on 2017/6/13.
 */
@Component
@Scope("prototype")
public class DefaultPipeline implements Pipeline {
    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public void process(ResultItems resultItems, Task task) {
        return;
    }
}
