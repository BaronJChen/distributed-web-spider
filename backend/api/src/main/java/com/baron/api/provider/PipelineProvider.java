package com.baron.api.provider;

import com.baron.common.annotation.SpiderProvider;
import com.baron.common.model.Page;

public interface PipelineProvider {
    void pipeline(String providerName, Page page);
}
