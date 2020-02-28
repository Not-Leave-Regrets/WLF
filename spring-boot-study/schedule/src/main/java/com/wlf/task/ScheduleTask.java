package com.wlf.task;

import org.springframework.scheduling.annotation.Scheduled;

/**
 * 静态定时任务
 * 1.在定时任务的方法上加注解@Scheduled()
 * 2.在启动类上加上注解@EnableSchedling
 */
public class ScheduleTask {
    @Scheduled(cron = "5-10 * * * * ?")
    public void scheduleTask1(){
        System.out.println(System.currentTimeMillis()+"定时任务1");
    }
    //initialDelay 启动开始多久开始执行 单位：毫秒
    //fixedDelay 执行任务开始就开始计时 单位：毫秒
    //fixedRate 执行完成后开始计时   单位：毫秒
//    @Scheduled(initialDelay =  1000 * 10,fixedDelay = 1000 * 5)
    public void scheduledTask2(){
        System.out.println("任务2执行时间："+System.currentTimeMillis());
        System.out.println("定时任务2");
        try {
            Thread.sleep(2*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("任务2结束时间："+System.currentTimeMillis());
    }

//    @Scheduled(initialDelay =  1000 * 10,fixedRate = 1000 * 5)
    public void scheduledTask3(){
        System.out.println("任务3执行时间："+System.currentTimeMillis());
        System.out.println("定时任务3");
        try {
            Thread.sleep(2*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("任务3结束时间："+System.currentTimeMillis());
    }

}
