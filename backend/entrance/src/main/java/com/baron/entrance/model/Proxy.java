package com.baron.entrance.model;

import com.baron.backend.common.model.BaseModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * Created by Jason on 2017/6/11.
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class Proxy extends BaseModel {
    private String ip;
    private int port;
    private String username;
    private String password;
}
