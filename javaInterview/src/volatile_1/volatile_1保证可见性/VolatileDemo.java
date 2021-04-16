package volatile_1.volatile_1保证可见性;

/**
 * @author fangsheng
 * @date 2021/4/7 下午5:04
 */

import java.util.concurrent.TimeUnit;

/**
 * 假设是主物理内存
 */
class MyData {
     int number = 0;

    public void addTo60() {
        this.number = 60;
    }
}

public class VolatileDemo {
    public static void main(String[] args) {
        MyData myData = new MyData();

        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "\t come in");

            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            myData.addTo60();

            System.out.println(Thread.currentThread().getName() + "\t update number value:" + myData.number);

        }, "AAA").start();

        while (myData.number == 0) {

        }

        System.out.println(Thread.currentThread().getName() + "\t mission is over");

    }
}
