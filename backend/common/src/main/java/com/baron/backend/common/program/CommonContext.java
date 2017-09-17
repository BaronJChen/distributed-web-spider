package com.baron.backend.common.program;

import org.springframework.context.ApplicationContext;

import java.util.HashMap;
import java.util.Map;

public class CommonContext {
    private static final String MAP_KEY_APPLICATION_CONTEXT = "applicationContext";
    private static CommonContext commonContext;

    static {
        commonContext = new CommonContext();
    }

    private final Map<Object, Object> map = new HashMap<>();

    private CommonContext() {}

    public static CommonContext getCommonContext() {
        return commonContext;
    }

    public void setApplicationContext(ApplicationContext applicationContext) {
        map.put(MAP_KEY_APPLICATION_CONTEXT, applicationContext);
    }

    public ApplicationContext getApplicationContext() {
        return (ApplicationContext)map.get(MAP_KEY_APPLICATION_CONTEXT);
    }
}
