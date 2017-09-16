package com.baron.backend.common.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class Proxy extends BaseModel {
    private String ip;
    private Integer port;
    private String username;
    private String password;
}
