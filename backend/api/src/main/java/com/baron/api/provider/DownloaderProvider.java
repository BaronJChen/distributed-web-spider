package com.baron.api.provider;

import com.baron.backend.common.model.Page;
import com.baron.backend.common.model.Request;
import com.baron.backend.common.model.SpiderTask;

public interface DownloaderProvider extends BaseProvider {
    Page download(Request request, SpiderTask spiderTask);
}
