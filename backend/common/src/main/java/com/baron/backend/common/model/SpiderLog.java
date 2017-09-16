package com.baron.backend.common.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;

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
public class SpiderLog extends BaseModel {
    private String spiderTaskId;
    private String unitTaskId;
    private String message;
    // trace, debug, info, warn, error
    private String level;
    private String throwable;
}
