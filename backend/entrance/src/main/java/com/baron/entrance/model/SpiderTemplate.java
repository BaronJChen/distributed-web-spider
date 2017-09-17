package com.baron.entrance.model;

import com.baron.backend.common.model.BaseModel;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * Created by Jason on 2017/6/11.
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Document
public class SpiderTemplate extends BaseModel {
    @NotNull
    private String name;
    @NotNull
    private String domain;

    private List<String> seeds;
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

    @NotNull
    private Boolean useProxy;
    @NotNull
    private List<String> analysors;
    @NotNull
    private List<String> downloaders;
    @NotNull
    private List<String> filters;
    @NotNull
    private List<String> pipelines;
    @NotNull
    private List<String> processors;
    @NotNull
    private List<String> registrar;

    public SpiderTemplate() {
        if (seeds == null || seeds.isEmpty()) {
            seeds = Arrays.asList(domain);
        }
    }
}
