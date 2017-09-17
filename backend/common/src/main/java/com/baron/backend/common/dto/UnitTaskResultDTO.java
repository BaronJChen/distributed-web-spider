package com.baron.backend.common.dto;

import com.baron.backend.common.model.BaseModel;
import com.baron.backend.common.model.SpiderThrowable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import net.minidev.json.JSONObject;

import java.util.List;

/**
 * Description:
 *
 * @author Jason
 * @date 2017/9/17 16:58
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class UnitTaskResultDTO extends BaseModel {
    private String spiderTaskId;
    private String unitTaskId;
    private List<String> urls;
    private JSONObject data;
    private Boolean success;
    private SpiderThrowable spiderThrowable;
}
