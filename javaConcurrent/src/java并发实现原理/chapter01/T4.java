package java并发实现原理.chapter01;

/**
 * @author fangsheng
 * @date 2021/6/4 11:07 上午
 */
public class T4 {
    public static void main(String[] args) {
        Thread thread = new Thread() {
            @Override
            public void run() {
                System.out.println("线程启动了");
                while (!isInterrupted()) {
                    System.out.println(isInterrupted());//调用 interrupt 之后为true
                }
                System.out.println("线程结束了");
            }
        };
        thread.start();

        thread.interrupt();

        try {
            thread.wait(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //true
        System.out.println("线程是否被中断：" + thread.isInterrupted());
    }
}
