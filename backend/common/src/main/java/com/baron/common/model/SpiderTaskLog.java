package com.baron.common.model;

import ch.qos.logback.classic.spi.IThrowableProxy;
import ch.qos.logback.classic.spi.ThrowableProxy;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

/**
 * Description:
 *
 * @author Jason
 * @date 2017/9/13 20:38
 */

@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Document(collection = "spider-task-log")
public class SpiderTaskLog extends BaseModel {
    private String taskId;
    private String message;
    // trace, debug, info, warn, error
    private String level;
    private IThrowableProxy iThrowableProxy;
}
