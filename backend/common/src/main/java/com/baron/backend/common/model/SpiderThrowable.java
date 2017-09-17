package com.baron.backend.common.model;

import com.baron.backend.common.model.BaseModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.List;

/**
 * Description:
 *
 * @author Jason
 * @date 2017/9/17 12:46
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class SpiderThrowable extends BaseModel {
    private String className;
    private String message;
    private List<StackTraceElement> stackTraceElenamements;
}
