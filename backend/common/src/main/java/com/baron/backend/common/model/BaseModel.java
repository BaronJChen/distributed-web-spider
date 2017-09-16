package com.baron.backend.common.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.Date;

@Data
@ToString
@EqualsAndHashCode
public abstract class BaseModel {
    String id;
    Boolean isDeleted;
    Date gmtCreated;
    Date gmtModified;

    public BaseModel() {
        isDeleted = false;
        gmtCreated = new Date();
    }
}
