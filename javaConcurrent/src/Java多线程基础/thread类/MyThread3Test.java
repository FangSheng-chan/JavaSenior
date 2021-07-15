package Java多线程基础.thread类;

/**
 * @author fangsheng
 * @date 2021/7/8 11:32 下午
 */
public class MyThread3Test {
    public static void main(String[] args) {
        MyThread3 myThread3 = new MyThread3("Thread : 1");
        myThread3.start();

        Thread.currentThread().setName("主线程");
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }

            if (i == 20) {
                try {
                    myThread3.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println(myThread3.isAlive());
    }
}
