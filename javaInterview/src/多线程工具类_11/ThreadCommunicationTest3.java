package 多线程工具类_11;

import java.util.concurrent.CountDownLatch;

/**
 * @author fangsheng
 * @date 2021/5/7 2:22 下午
 */
public class ThreadCommunicationTest3 {

    CountDownLatch latch1 = new CountDownLatch(5);
    CountDownLatch latch2 = new CountDownLatch(1);

    public void f1() {
        for (int i = 1; i <= 10; i++) {
            System.out.println("add" + i);
            latch1.countDown();
            if (i == 5) {
                try {
                    latch2.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void f2() {
        try {
            latch1.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("size等于5");
        latch2.countDown();
    }

    public static void main(String[] args) {
        ThreadCommunicationTest3 t = new ThreadCommunicationTest3();
        new Thread(t::f2).start();
        new Thread(t::f1).start();
    }

}
