package com.baron.entrance.object;

import com.baron.backend.common.log.SpiderLogger;
import com.baron.backend.common.program.CommonRequestContext;
import com.baron.backend.common.webmagic.Page;
import com.baron.backend.common.webmagic.Request;
import com.baron.backend.common.webmagic.Site;
import com.baron.backend.common.webmagic.SpiderListener;
import com.baron.backend.common.webmagic.downloader.Downloader;
import com.baron.backend.common.webmagic.downloader.HttpClientDownloader;
import com.baron.backend.common.webmagic.pipeline.CollectorPipeline;
import com.baron.backend.common.webmagic.pipeline.ConsolePipeline;
import com.baron.backend.common.webmagic.pipeline.Pipeline;
import com.baron.backend.common.webmagic.pipeline.ResultItemsCollectorPipeline;
import com.baron.backend.common.webmagic.processor.PageProcessor;
import com.baron.backend.common.webmagic.scheduler.QueueScheduler;
import com.baron.backend.common.webmagic.scheduler.Scheduler;
import com.baron.backend.common.webmagic.thread.CountableThreadPool;
import com.baron.backend.common.webmagic.utils.UrlUtils;
import com.baron.backend.common.webmagic.utils.WMCollections;
import com.baron.entrance.concurrent.ThreadPoolBuilder;
import com.baron.entrance.model.SpiderTask;
import com.baron.entrance.model.SpiderTemplate;
import com.baron.entrance.model.State;
import com.baron.entrance.model.UnitTask;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.SerializationUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sun.security.provider.ConfigFile;

import java.io.Closeable;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Description:
 *
 * @author Jason
 * @date 2017/9/17 17:54
 */
@Data
public class Spider implements Runnable {
    private static final SpiderLogger logger = SpiderLogger.getSpiderLogger(Spider.class);

    private SpiderTask spiderTask;
    private SpiderTemplate spiderTemplate;
    private ExecutorService executorService;
    private Queue<UnitTask> unitTasks;
    private Set<String> duplicateRemover;

    public Spider(SpiderTask spiderTask) {
        this.spiderTask = spiderTask;
    }

    private void init() {
        CommonRequestContext.getContext().setSpiderTaskId(spiderTask.getId());

        this.spiderTemplate = spiderTask.getSpiderTemplate();
        this.executorService = new ThreadPoolBuilder()
                .threadCount(spiderTask.getSpiderTemplate().getThreadCount())
                .build();
        this.unitTasks = spiderTask.getUnitTasks();
        this.duplicateRemover = new HashSet<>();

        initTasks();
    }

    private void initTasks() {
        for (String seed : spiderTemplate.getSeeds()) {
            if (duplicateRemover.contains(seed)) {
                continue;
            }

            UnitTask unitTask = assembleNewTask(seed);
            unitTasks.add(unitTask);
        }
    }

    @Override
    public void run() {
        logger.info("开始初始化");
        init();
        logger.info("初始化完成");

//        checkRunningStat();
//        initComponent();
//        logger.info("Spider {} started!",getUUID());
//        while (!Thread.currentThread().isInterrupted() && stat.get() == STAT_RUNNING) {
//            final Request request = scheduler.poll(this);
//            if (request == null) {
//                if (threadPool.getThreadAlive() == 0 && exitWhenComplete) {
//                    break;
//                }
//                // wait until new url added
//                waitNewUrl();
//            } else {
//                threadPool.execute(new Runnable() {
//                    @Override
//                    public void run() {
//                        try {
//                            processRequest(request);
//                            onSuccess(request);
//                        } catch (Exception e) {
//                            onError(request);
//                            logger.error("process request " + request + " error", e);
//                        } finally {
//                            pageCount.incrementAndGet();
//                            signalNewUrl();
//                        }
//                    }
//                });
//            }
//        }
//        stat.set(STAT_STOPPED);
//        // release some resources
//        if (destroyWhenExit) {
//            close();
//        }
//        logger.info("Spider {} closed! {} pages downloaded.", getUUID(), pageCount.get());
    }

    private UnitTask assembleNewTask(String url) {
        UnitTask unitTask = new UnitTask();

        unitTask.setSpiderTemplateId(spiderTemplate.getId());
        unitTask.setSpiderTaskId(spiderTask.getId());
        unitTask.setUrl(seed);

        return unitTask;
    }
}
