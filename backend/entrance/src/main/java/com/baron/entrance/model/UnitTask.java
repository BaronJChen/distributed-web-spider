package com.baron.entrance.model;

import com.baron.backend.common.model.BaseModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

/**
 * Created by Baron.Chen on 2017/6/15.
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Document(collection = "unit_task")
public class UnitTask extends BaseModel {
    private String spiderTaskId;
    private String spiderTemplateId;
    private String url;
    private String html;
    private Date startedDate;
    private Date finishedAt;
    private Boolean succeeded;
    private Integer statusCode;
    private Object result;
}