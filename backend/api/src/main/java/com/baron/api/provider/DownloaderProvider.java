package com.baron.api.provider;

import com.baron.common.annotation.SpiderProvider;
import com.baron.common.model.Page;
import com.baron.common.model.Request;
import com.baron.common.model.SpiderTask;
import com.baron.common.model.UnitTask;

public interface DownloaderProvider extends BaseProvider {
    Page download(Request request, SpiderTask spiderTask);
}
