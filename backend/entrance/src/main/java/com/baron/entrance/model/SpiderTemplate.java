package com.baron.entrance.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Map;

/**
 * Created by Jason on 2017/6/11.
 */
@Data
@Document
public class SpiderTemplate {
    @Id
    private String id;
    // 模板的名称
    private String name;
    // 模板作用的域
    private String domain;
    // 起始URL
    private List<String> seeds;
    // 线程的数量
    private Integer threadCount;

    private Integer retryCount;
    private Integer sleepTime;
    private Long maxPageCount;
    private Integer timeout;
    private List<String> urlRegexes;
    private Map<String, String> cookies;
    private Map<String, String> headers;
    private String pageEncoding;
    private Map<String, MatchExpression> expressions;
    private Map<String, String> tags;
    private List<String> taskCallbacks;
    private List<String> unitCallbacks;
    private List<String> filters;
    private List<String> pipelines;
    private String pageProcessor;

}
