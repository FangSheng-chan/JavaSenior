package java并发实现原理.chapter01;

/**
 * @author fangsheng
 * @date 2021/6/8 3:48 下午
 */
public class T13 {

    private static int count;

    public T13() {
        count = 0;
    }

    public static void method() {
            for (int i = 0; i < 5; i++) {
                try {
                    System.out.println(Thread.currentThread().getName() + ":" + (count++));
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
        }
    }

    public static void method2() {

            for (int i = 0; i < 5; i++) {
                try {
                    System.out.println(Thread.currentThread().getName() + ":" + (count=+5));
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

    }
}
