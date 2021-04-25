package CAS_2.CAS_1底层原理;

import java.util.Arrays;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author fangsheng
 * @date 2021/4/19 下午4:24
 */
public class CASDemo01 {
    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(5);

        System.out.println(atomicInteger.compareAndSet(5, 2019) + "\t current data: " + atomicInteger.get());

        System.out.println(atomicInteger.compareAndSet(5, 1024) + "\t current data: " + atomicInteger.get());

        atomicInteger.getAndIncrement();

        System.out.println(atomicInteger.get());

        HashMap<Object, Object> hashMap = new HashMap<>();
        hashMap.put(1,1);
        hashMap.put(1,2);
        System.out.println(hashMap);

    }
}
