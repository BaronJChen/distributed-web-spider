package com.baron.common.model;

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
    Date created;
    Date modified;

    public BaseModel() {
        isDeleted = false;
        created = new Date();
    }
}
