package ABA_3;

import org.omg.PortableServer.THREAD_POLICY_ID;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @author fangsheng
 * @date 2021/4/22 下午3:46
 */
public class ABADemo {

    static AtomicReference<Integer> atomicReference2 = new AtomicReference(1);

    static AtomicInteger atomicReference = new AtomicInteger(1);

    /**
     * 手写一个ABA问题
     *
     * @param args
     */
    public static void main(String[] args) {
        new Thread(() -> {
            atomicReference.compareAndSet(1, 2);
            atomicReference.compareAndSet(2, 1);
        }).start();

        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(atomicReference.compareAndSet(1, 2000) + "\t" + atomicReference.get());
        }).start();
    }
}
