package Java多线程基础.thread类;

/**
 * @author fangsheng
 * @date 2021/7/8 11:18 下午
 */
public class MyThread extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        }
    }
}
