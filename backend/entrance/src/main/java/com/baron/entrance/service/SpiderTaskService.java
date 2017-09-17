package com.baron.entrance.service;

import com.baron.entrance.dao.SpiderTaskDao;
import com.baron.entrance.model.SpiderTask;
import com.baron.entrance.model.SpiderTemplate;
import com.baron.entrance.model.State;
import com.baron.entrance.dao.SpiderTemplateDao;
import com.google.common.base.Preconditions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Jason on 2017/6/13.
 */
@Service
public class SpiderTaskService extends BaseService {
    @Autowired
    private SpiderTemplateDao spiderTemplateDao;
    @Autowired
    private SpiderTaskDao spiderTaskDao;

    public SpiderTask add(SpiderTemplate spiderTemplate) {
        SpiderTask spiderTask = new SpiderTask();
        spiderTask.setSpiderTemplate(spiderTemplate);

        return spiderTaskDao.save(spiderTask);
    }

    public SpiderTask add(String spiderTemplateId) {
        Preconditions.checkArgument(spiderTemplateId == null || spiderTemplateId.trim().isEmpty());
        return add(spiderTemplateDao.findById(spiderTemplateId));
    }
}
