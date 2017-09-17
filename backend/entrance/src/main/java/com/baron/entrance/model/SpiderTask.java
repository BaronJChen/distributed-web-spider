package com.baron.entrance.model;

import com.baron.backend.common.model.BaseModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.eclipse.jetty.util.BlockingArrayQueue;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Baron.Chen on 2017/6/9.
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class SpiderTask extends BaseModel {
    @NotNull
    private SpiderTemplate spiderTemplate;
    private long successCount;
    private long failureCount;
    private Date startDate;
    private Date finishDate;
    private State state;
    private List<UnitTask> unitTasks;
    private List<UnitTaskResult> unitTaskResults;

    public SpiderTask() {
        unitTasks = new BlockingArrayQueue<>();
        state = State.CREATING;
        unitTaskResults = new ArrayList<>();
        unitTasks = new ArrayList<>();
    }
}
