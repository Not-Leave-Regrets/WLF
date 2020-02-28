package com.wlf.task;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * 多线程的定时任务
 * 1.在需要的定时任务上加上注解@Async
 * 2.在启动类上加上注解@EnableScheduling(打开定时任务)和注解@EnableAsync(打开多线程)
 */

@Component
public class MutiThreadSchedule  {

    @Async
    @Scheduled(fixedDelay = 1000)
    public void MutiThreadTask1() throws InterruptedException {
        System.out.println("第一个线程任务" + Thread.currentThread().getName() +"时间："+System.currentTimeMillis());
        System.out.println();
        
        
    }
    @Async
    @Scheduled(fixedDelay = 2000)
    public void MutiThreadTask2() throws InterruptedException {
        System.out.println("第二个线程任务" + Thread.currentThread().getName() +"时间："+System.currentTimeMillis());
    }
}
