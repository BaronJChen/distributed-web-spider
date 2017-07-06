package com.baron.entrance.program;

import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

/**
 * Created by Baron.Chen on 2017/6/15.
 */
@Component
public class App {
    private List<String> filters;
    private List<String> pageProcessors;
    private List<String> pipelines;
    private List<String> schedulers;
    private List<String> downloaders;
    private Date startedAt;
}
