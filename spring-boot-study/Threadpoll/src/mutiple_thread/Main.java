package mutiple_thread;

public class Main {
    static int a =0;
    public static void main(String[] args){

        ThreadPoll threadPoll = new ThreadPoll();
        for (int i=0;i<11;i++) {
            Runnable r1 = new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(10);
                        System.out.println("当前是"+a+++"任务在被执行");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };
            threadPoll.add(r1);
        }
    }
}
