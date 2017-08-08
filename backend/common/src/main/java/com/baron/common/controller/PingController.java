package com.baron.common.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2017/7/5 0005.
 */
@RestController
public class PingController {
    @GetMapping
    public String index() {
        return "this is api";
    }
}
