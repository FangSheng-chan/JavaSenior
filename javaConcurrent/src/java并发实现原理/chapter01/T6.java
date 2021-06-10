package java并发实现原理.chapter01;

/**
 * @author fangsheng
 * @date 2021/6/4 11:16 上午
 */
public class T6 {
    public static void main(String[] args) throws InterruptedException {

        Thread currentThread = Thread.currentThread();

        Thread thread = new Thread() {
            @Override
            public void run() {
                System.out.println("线程启动了");
                //对于这种情况，即使线程调用了intentrupt()方法并且isInterrupted()，但线程还是会继续运行，根本停不下来！
                while (!interrupted()) {

                }
            }
        };
        thread.start();
        currentThread.interrupt();
        Thread.sleep(1000);
        //注意，此方法不会中断一个正在运行的线程，它的作用是：在线程受到阻塞时抛出一个中断信号，这样线程就得以退出阻塞的状态
        while (!Thread.interrupted()) {
            //true
            System.out.println("是否isInterrupted：" + thread.isInterrupted());
            thread.interrupt();
        }

    }
}
