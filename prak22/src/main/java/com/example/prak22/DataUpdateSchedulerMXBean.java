package com.example.prak22;

import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.stereotype.Component;

@Component
@ManagedResource(objectName = "com.example:type=DataUpdateScheduler")
public class DataUpdateSchedulerMXBean {

    private final DataUpdateScheduler dataUpdateScheduler;

    public DataUpdateSchedulerMXBean(DataUpdateScheduler dataUpdateScheduler) {
        this.dataUpdateScheduler = dataUpdateScheduler;
    }

    @ManagedOperation(description = "Invoke data update task")
    public void invokeDataUpdateTask() {
        dataUpdateScheduler.updateData();
    }
}

