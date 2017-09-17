package com.baron.entrance.model;

import com.baron.backend.common.model.BaseModel;
import com.baron.backend.common.model.SpiderThrowable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.List;

/**
 * Description:
 *
 * @author Jason
 * @date 2017/9/17 12:43
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class UnitTaskResult extends BaseModel {
    private String spiderTaskId;
    private String unitTaskId;
    private List<String> urls;
    private String data;
    private Boolean success;
    private SpiderThrowable spiderThrowable;
}