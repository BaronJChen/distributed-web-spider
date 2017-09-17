package com.baron.backend.common.program;

import lombok.Data;
import org.springframework.data.mongodb.core.MongoTemplate;

@Data
public class CommonRequestContext {
    private static final ThreadLocal<CommonRequestContext> threadLocal = new ThreadLocal<>();

    private MongoTemplate mongoTemplate;

    private String spiderTaskId;

    private String unitTaskId;

    private CommonRequestContext() {
        init();
    }

    public static CommonRequestContext getContext() {
        if (threadLocal.get() == null) {
            threadLocal.set(new CommonRequestContext());
        } // if

        return threadLocal.get();
    }

    public void reset() {
        init();
    }

    private void init() {
        unitTaskId = "";
        spiderTaskId = "";
        mongoTemplate = CommonContext.getCommonContext().getApplicationContext().getBean(MongoTemplate.class);
    }
}
