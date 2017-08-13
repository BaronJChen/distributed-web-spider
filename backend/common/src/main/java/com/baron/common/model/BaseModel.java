package com.baron.common.model;

import lombok.Data;

import java.util.Date;

@Data
public abstract class BaseModel {
    protected String id;
    protected boolean isDeleted;
    protected Date created;
    protected Date modified;
}
