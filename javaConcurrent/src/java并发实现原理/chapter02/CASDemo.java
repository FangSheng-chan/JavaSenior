package java并发实现原理.chapter02;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author fangsheng
 * @date 2021/6/15 2:36 下午
 */
public class CASDemo {
    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(5);
        System.out.println(atomicInteger.compareAndSet(5, 2019) + "\t" + atomicInteger.get());
        System.out.println(atomicInteger.compareAndSet(5, 2019) + "\t" + atomicInteger.get());
    }
}
