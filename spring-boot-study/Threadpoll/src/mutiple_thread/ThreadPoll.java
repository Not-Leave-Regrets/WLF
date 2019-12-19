package mutiple_thread;

import java.util.LinkedList;

/**
 * 线程池的思路和生产者消费者模型是很接近的。
 * 1. 准备一个任务容器
 * 2. 一次性启动10个 消费者线程
 * 3. 刚开始任务容器是空的，所以线程都wait在上面。
 * 4. 直到一个外部线程往这个任务容器中扔了一个“任务”，就会有一个消费者线程被唤醒notify
 * 5. 这个消费者线程取出“任务”，并且执行这个任务，执行完毕后，继续等待下一次任务的到来。
 * 6. 如果短时间内，有较多的任务加入，那么就会有多个线程被唤醒，去执行这些任务。
 *
 * 在整个过程中，都不需要创建新的线程，而是循环使用这些已经存在的线程
 */
public class ThreadPoll {
    LinkedList<Runnable> tasks = new LinkedList<>();
    int initSize =10;
    public ThreadPoll(){
        synchronized (tasks){
            for (int i = 0 ;i<initSize;i++){
                new ThreadConsumeThread().start();
            }
        }
    }
    public void add(Runnable runnable){
        synchronized (tasks){
            tasks.add(runnable);
            tasks.notifyAll();
        }
    }
    class ThreadConsumeThread extends  Thread{
        Runnable r;

        @Override
        public void run() {
            /**
             * 死循环执行run，当没有任务时，当前线程进入等待状态。当有新的任务add进来之后会唤醒所有的等待线程。
             * 死循环执行run可以保证当前线程不会因为run执行结束导致而销毁
             */


            while (true){
                synchronized (tasks){
                    while(tasks.isEmpty())
                    {
                        try {
                            tasks.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    r = tasks.removeLast();
                    tasks.notifyAll();
                }
                System.out.println(this.getName()+"获取到任务并执行");
                r.run();
            }
        }
    }
}
