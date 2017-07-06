package com.baron.entrance.analyzer;

import com.baron.entrance.model.SpiderTask;

/**
 * Created by Baron.Chen on 2017/6/16.
 */
public interface Analyzer {
    default void analyze(SpiderTask spiderTask) {
        return;
    }
}
