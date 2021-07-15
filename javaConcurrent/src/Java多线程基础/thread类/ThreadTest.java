package Java多线程基础.thread类;

/**
 * @author fangsheng
 * @date 2021/7/8 11:19 下午
 */
public class ThreadTest {
    public static void main(String[] args) {
        MyThread myThread1 = new MyThread();
        MyThread2 myThread2 = new MyThread2();
        myThread1.start();
        myThread2.start();

    }
}
