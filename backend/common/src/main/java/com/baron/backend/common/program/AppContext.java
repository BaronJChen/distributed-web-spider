package com.baron.backend.common.program;

import org.springframework.context.ApplicationContext;

import java.util.HashMap;
import java.util.Map;

public class AppContext {
    private static final String MAP_KEY_APPLICATION_CONTEXT = "applicationContext";
    private static AppContext appContext;

    static {
        appContext = new AppContext();
    }

    private final Map<Object, Object> map = new HashMap<>();

    private AppContext() {}

    public static AppContext getAppContext() {
        return appContext;
    }

    public void setApplicationContext(ApplicationContext applicationContext) {
        map.put(MAP_KEY_APPLICATION_CONTEXT, applicationContext);
    }

    public ApplicationContext getApplicationContext() {
        return (ApplicationContext)map.get(MAP_KEY_APPLICATION_CONTEXT);
    }
}
