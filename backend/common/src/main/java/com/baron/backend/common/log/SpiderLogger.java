package com.baron.backend.common.log;

import com.alibaba.fastjson.JSON;
import com.baron.backend.common.program.RequestContext;
import com.baron.backend.common.model.SpiderLog;
import ch.qos.logback.classic.Level;
import org.springframework.data.mongodb.core.MongoTemplate;

/**
 * Description: 用于融合Logback以及私下给spider打日志
 *
 * @author Jason
 * @date 2017/9/16 12:22
 */

public class SpiderLogger extends org.apache.log4j.Logger {
    protected SpiderLogger(String name) {
        super(name);
    }

    public static SpiderLogger getSpiderLogger(Class<?> clazz) {
        return new SpiderLogger(clazz.getName());
    }

    public static SpiderLogger getSpiderLogger(String name) {
        return new SpiderLogger(name);
    }

    public void spiderTrace(Object message) {
        spiderLog(message, Level.TRACE, null);
    }

    public void spiderDebug(Object message) {
        spiderLog(message, Level.DEBUG, null);

    }

    public void spiderInfo(Object message) {
        spiderLog(message, Level.INFO, null);
    }

    public void spiderWarn(Object message) {
        spiderLog(message, Level.WARN, null);

    }

    public void spiderError(Object message, Throwable throwable) {
        spiderLog(message, Level.ERROR, throwable);
    }

    private void spiderLog(Object message, Level level, Throwable throwable) {
        MongoTemplate mongoTemplate = RequestContext.getContext().getMongoTemplate();
        String taskId = RequestContext.getContext().getSpiderTaskId();

        SpiderLog spiderTaskLog = new SpiderLog();

        spiderTaskLog.setLevel(level.levelStr);
        spiderTaskLog.setSpiderTaskId(taskId);
        spiderTaskLog.setMessage(JSON.toJSONString(message));
        spiderTaskLog.setThrowable(JSON.toJSONString(throwable));

        mongoTemplate.save(spiderTaskLog);
    }
}
