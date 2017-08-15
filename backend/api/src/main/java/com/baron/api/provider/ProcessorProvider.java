package com.baron.api.provider;

import com.baron.common.annotation.SpiderProvider;
import com.baron.common.model.Page;

public interface ProcessorProvider extends BaseProvider {
    Page process(String name, Page page);
}
