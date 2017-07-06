package com.baron.gateway.service;

import com.baron.gateway.concurrent.ThreadPoolBuilder;
import com.baron.gateway.model.SpiderTask;
import com.baron.gateway.model.SpiderTemplate;
import com.baron.gateway.repository.SpiderTemplateRepository;
import com.baron.gateway.program.AppConstants;
import com.google.common.base.Preconditions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutorService;

/**
 * Created by Jason on 2017/6/13.
 */
@Service
public class SpiderTaskService extends BaseService {
    @Autowired
    private SpiderTemplateRepository spiderTemplateRepository;

    public SpiderTask add(SpiderTemplate spiderTemplate) {
        SpiderTask spiderTask = new SpiderTask();
        ExecutorService service = new ThreadPoolBuilder().threadCount(spiderTemplate.getThreadCount()).build();

        return null;
    }

    public SpiderTask add(String spiderTemplateId) {
        Preconditions.checkArgument(spiderTemplateId == null || spiderTemplateId.trim().length() == 0
                , AppConstants.CHECK_ARGUMENT_SPIDER_TEMPLATE_ID_NULL);
        return add(spiderTemplateRepository.findById(spiderTemplateId));
    }
}
