package com.baron.backend.common.program;

import lombok.Data;
import org.springframework.data.mongodb.core.MongoTemplate;

@Data
public class RequestContext {
    private static final ThreadLocal<RequestContext> threadLocal = new ThreadLocal<>();

    private MongoTemplate mongoTemplate;

    private String spiderTaskId;

    private String unitTaskId;

    private RequestContext() {
        init();
    }

    public static RequestContext getContext() {
        if (threadLocal.get() == null) {
            threadLocal.set(new RequestContext());
        } // if

        return threadLocal.get();
    }

    public void reset() {
        init();
    }

    private void init() {
        unitTaskId = "";
        spiderTaskId = "";
        mongoTemplate = AppContext.getAppContext().getApplicationContext().getBean(MongoTemplate.class);
    }
}
