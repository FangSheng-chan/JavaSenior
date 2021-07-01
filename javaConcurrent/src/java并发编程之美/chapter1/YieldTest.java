package java并发编程之美.chapter1;

/**
 * @author fangsheng
 * @date 2021/6/29 7:32 下午
 */
public class YieldTest implements Runnable {

    YieldTest() {
        Thread thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            if (i % 5 == 0) {
                System.out.println(Thread.currentThread() + "yield cpu....");
//                Thread.yield();
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
            }
        }
        System.out.println(Thread.currentThread() + "IS OVER");
    }

    public static void main(String[] args) {
        new YieldTest();
        new YieldTest();
        new YieldTest();
    }
}
