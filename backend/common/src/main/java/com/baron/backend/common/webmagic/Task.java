package com.baron.backend.common.webmagic;

import com.baron.backend.common.webmagic.Site;

/**
 * Interface for identifying different tasks.<br>
 *
 * @author code4crafter@gmail.com <br>
 * @since 0.1.0
 * @see com.baron.backend.common.webmagic.scheduler.Scheduler
 * @see com.baron.backend.common.webmagic.pipeline.Pipeline
 */
public interface Task {

    /**
     * unique id for a task.
     *
     * @return uuid
     */
    public String getUUID();

    /**
     * site of a task
     *
     * @return site
     */
    public Site getSite();

}
