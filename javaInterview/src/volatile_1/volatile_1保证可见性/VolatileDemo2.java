package volatile_1.volatile_1保证可见性;

import java.util.concurrent.TimeUnit;

/**
 * @author fangsheng
 * @date 2021/4/13 下午3:55
 */

class Data {

    volatile int number = 0;

    public void addTo60(int number) {
        this.number = 60;
    }

}

public class VolatileDemo2 {
    public static void main(String[] args) {
        Data data = new Data();

        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "\t come in");
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            data.addTo60(60);
            System.out.println(Thread.currentThread().getName() + "\t update number value:" + data.number);

        }, "AAA").start();

        System.out.println(data.number);

        while (data.number == 0) {

        }

        System.out.println("mission is over");
    }
}
