package java并发实现原理.chapter01;


/**
 * @author fangsheng
 * @date 2021/6/8 2:49 下午
 */
public class Test {
    public static void main(String[] args) {
//        T12 thread = new T12();
//        Thread thread1 = new Thread(thread, "thread1");
//        Thread thread2 = new Thread(thread, "thread2");
//        thread1.start();
//        thread2.start();
//        T12 thread = new T12();
//        Thread thread1 = new Thread(new T12(), "thread1");
//        Thread thread2 = new Thread(new T12(), "thread2");
//        thread1.start();
//        thread2.start();
//        Counter counter = new Counter();
//        Thread thread1 = new Thread(counter, "A");
//        Thread thread2 = new Thread(counter, "B");
//        thread1.start();
//        thread2.start();
//        Account account = new Account("zhang san", 0.0f);
//        AccountOperator accountOperator = new AccountOperator(account);
//
//        final int THREAD_NUM = 5;
//        Thread threads[] = new Thread[THREAD_NUM];
//        for (int i = 0; i < THREAD_NUM; i++) {
//            threads[i] = new Thread(accountOperator, "Thread" + i);
//            threads[i].start();
//        }
        T13 thread1 = new T13();
        T13 thread2 = new T13();
        Thread t1 = new Thread(thread1, "t1");
        Thread t2 = new Thread(thread1, "t2");
        t1.start();
        t2.start();
    }
}
