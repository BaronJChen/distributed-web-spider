package com.baron.gateway.analyzer;

import com.baron.gateway.model.SpiderTask;

/**
 * Created by Baron.Chen on 2017/6/16.
 */
public interface Analyzer {
    default void analyze(SpiderTask spiderTask) {
        return;
    }
}
