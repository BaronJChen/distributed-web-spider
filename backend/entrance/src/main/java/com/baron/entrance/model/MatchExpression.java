package com.baron.entrance.model;

import com.baron.backend.common.model.BaseModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * Created by Jason on 2017/6/11.
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class MatchExpression extends BaseModel {
    private String regex;
    private String xpath;
}
