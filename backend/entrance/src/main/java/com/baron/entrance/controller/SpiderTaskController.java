package com.baron.entrance.controller;

import com.baron.entrance.model.SpiderTask;
import com.baron.entrance.service.SpiderTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Jason on 2017/6/15.
 */
@RestController
@RequestMapping("/spider-task")
public class SpiderTaskController {
    @Autowired
    private SpiderTaskService spiderTaskService;

    @RequestMapping(method = RequestMethod.POST)
    public SpiderTask add(@RequestParam String spiderTemplateId) {
        return spiderTaskService.add(spiderTemplateId);
    }
}
