package java并发实现原理.chapter02;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author fangsheng
 * @date 2021/6/10 4:17 下午
 */
class Data {

}

public class AtomicIntegerDemo {

    private AtomicInteger count = new AtomicInteger();

    AtomicBoolean atomicBoolean = new AtomicBoolean();

    public void setTrue() {
        atomicBoolean.compareAndSet(false, true);
    }

    public void increment() {
        count.getAndIncrement();
    }

    public static void main(String[] args) {

        AtomicIntegerDemo demo = new AtomicIntegerDemo();
//
//        for (int i = 0; i < 10; i++) {
//            new Thread(() -> {
//                for (int j = 0; j < 2000; j++) {
//                    demo.increment();
//                }
//            }).start();
//        }
//        while (Thread.activeCount() > 2) {
//            Thread.yield();
//        }
//        System.out.println(Thread.currentThread().getName() + demo.count);

        new Thread(() -> {
            demo.setTrue();
        }).start();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(demo.atomicBoolean.get());
    }


}
