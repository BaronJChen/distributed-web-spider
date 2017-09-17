package com.baron.entrance.processor;

import com.baron.entrance.model.SpiderTask;
import com.baron.entrance.model.SpiderTemplate;
import com.baron.entrance.program.AppCache;
import com.baron.entrance.program.AppConstants;
import com.baron.backend.common.webmagic.Page;
import com.baron.backend.common.webmagic.Site;
import com.baron.backend.common.webmagic.processor.PageProcessor;

/**
 * Created by Jason on 2017/6/13.
 */
public class SpiderPageProcessor implements PageProcessor {
    @Override
    public void process(Page page) {
        SpiderTask spiderTask = AppCache.getThreadLocal(AppConstants.THREAD_LOCAL_CACHE_SPIDER_TASK);
        SpiderTemplate spiderTemplate = AppCache.getThreadLocal(AppConstants.THREAD_LOCAL_CACHE_SPIDER_TEMPLATE);
    }

    @Override
    public Site getSite() {
        return AppCache.getThreadLocal(AppConstants.THREAD_LOCAL_CACHE_SPIDER_THREAD_SITE);
    }
}
