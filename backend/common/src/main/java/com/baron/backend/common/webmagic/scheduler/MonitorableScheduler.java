package com.baron.backend.common.webmagic.scheduler;

import com.baron.backend.common.webmagic.Task;
import com.baron.backend.common.webmagic.scheduler.Scheduler;

/**
 * The scheduler whose requests can be counted for monitor.
 *
 * @author code4crafter@gmail.com
 * @since 0.5.0
 */
public interface MonitorableScheduler extends Scheduler {

    public int getLeftRequestsCount(Task task);

    public int getTotalRequestsCount(Task task);

}