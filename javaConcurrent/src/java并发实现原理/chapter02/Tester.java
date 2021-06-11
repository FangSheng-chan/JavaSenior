package java并发实现原理.chapter02;

/**
 * @author fangsheng
 * @date 2021/6/10 4:59 下午
 */
public class Tester {
    private static final Worker worker = new Worker();

    public static void testSynchronized(){
        Thread t1 = new Thread(() -> worker.work1("A"));
        Thread t2 = new Thread(() -> worker.work1("B"));
        Thread t3 = new Thread(() -> worker.work1("C"));
        Thread t4 = new Thread(() -> worker.work1("D"));
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
    public static void testTryLock(){
        Thread t1 = new Thread(() -> worker.work2("A"));
        Thread t2 = new Thread(() -> worker.work2("B"));
        Thread t3 = new Thread(() -> worker.work2("C"));
        Thread t4 = new Thread(() -> worker.work2("D"));
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
    public static void testLockInterruptibly(){
        Thread t1 = new Thread(() -> worker.work3("A"));
        Thread t2 = new Thread(() -> worker.work3("B"));
        Thread t3 = new Thread(() -> worker.work3("C"));
        Thread t4 = new Thread(() -> worker.work3("D"));
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
    public static void main(String[] args) {
        testSynchronized();
    }
}
