package com.baron.common.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
public class Proxy extends BaseModel {
    private String ip;
    private Integer port;
    private String username;
    private String password;
}
