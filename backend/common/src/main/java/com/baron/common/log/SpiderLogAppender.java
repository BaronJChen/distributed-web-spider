package com.baron.common.log;

import ch.qos.logback.classic.spi.LoggingEvent;
import ch.qos.logback.core.ConsoleAppender;
import com.alibaba.fastjson.JSON;
import com.baron.common.model.SpiderTaskLog;
import com.baron.common.program.RequestContext;
import org.springframework.data.mongodb.core.MongoTemplate;

/**
 * Description: use this thing to record spider task log
 *
 * @author Jason
 * @date 2017/9/13 20:37
 */

public class SpiderLogAppender<E>  extends ConsoleAppender<E> {

    @Override
    protected void append(E eventObject) {
        super.append(eventObject);

        String taskId = RequestContext.getContext().getSpiderTaskId();
        if (taskId == null || taskId.trim().isEmpty()) {
            return;
        }

        LoggingEvent loggingEvent = (LoggingEvent)eventObject;
        MongoTemplate mongoTemplate = RequestContext.getContext().getMongoTemplate();
        SpiderTaskLog spiderTaskLog = new SpiderTaskLog();

        spiderTaskLog.setLevel(loggingEvent.getLevel().levelStr);
        spiderTaskLog.setTaskId(taskId);
        spiderTaskLog.setMessage(loggingEvent.getFormattedMessage());
        spiderTaskLog.setIThrowableProxy(loggingEvent.getThrowableProxy());

        mongoTemplate.save(spiderTaskLog);
    }
}
