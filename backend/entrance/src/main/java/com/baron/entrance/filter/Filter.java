package com.baron.entrance.filter;

import com.baron.backend.common.webmagic.Page;
import com.baron.backend.common.webmagic.ResultItems;

/**
 * Created by Jason on 2017/6/11.
 */
public interface Filter {
    default boolean filter(Page page, ResultItems resultItems) {
        return true;
    }
}
