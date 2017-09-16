package com.baron.api.provider;

import com.baron.backend.common.model.Page;

public interface PipelineProvider extends BaseProvider {
    void pipeline(String providerName, Page page);
}
