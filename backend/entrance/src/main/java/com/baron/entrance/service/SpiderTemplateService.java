package com.baron.entrance.service;

import com.baron.entrance.model.SpiderTemplate;
import com.baron.entrance.dao.SpiderTemplateDao;
import com.google.common.base.Preconditions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Jason on 2017/6/13.
 */
@Service
public class SpiderTemplateService extends BaseService {
    @Autowired
    private SpiderTemplateDao spiderTemplateDao;

    public void add(SpiderTemplate spiderTemplate) {
        if (spiderTemplate == null) {
            return;
        } // if

        Preconditions.checkArgument(spiderTemplate.getName() != null);
        Preconditions.checkArgument(spiderTemplate.getDomain() != null);

        spiderTemplateDao.save(spiderTemplate);
    }
}
