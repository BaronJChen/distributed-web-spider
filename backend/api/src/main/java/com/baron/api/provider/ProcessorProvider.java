package com.baron.api.provider;

import com.baron.backend.common.model.Page;

public interface ProcessorProvider extends BaseProvider {
    Page process(String name, Page page);
}
