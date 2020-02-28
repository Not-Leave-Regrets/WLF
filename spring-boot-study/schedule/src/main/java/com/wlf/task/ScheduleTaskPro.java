package com.wlf.task;

import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;
/**
 * 动态的定时任务
 * 1.创建一个类实现SchedulingConfigurer接口
 */

public class ScheduleTaskPro implements SchedulingConfigurer {

    @Override
    public void configureTasks(ScheduledTaskRegistrar scheduledTaskRegistrar) {
         //1.添加定时任务
        scheduledTaskRegistrar.addTriggerTask(
                //2.添加任务内容
                ()->System.out.println("定时任务4" + System.currentTimeMillis()),
                //3.设置执行周期
                triggerContext -> {
                    String cron = getCron();
                    if(cron.isEmpty()){
                        return null;
                    }
                    return new CronTrigger(cron).nextExecutionTime(triggerContext);
                }
        );
    }
    /**
     * 执行定时任务.
     */
    public String getCron(){
        return "1-10 * * * * ?";
    }
}
