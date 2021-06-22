package java并发实现原理.chapter05;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author fangsheng
 * @date 2021/6/21 7:15 下午
 */
public class Test {
    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(1);
        System.out.println(atomicInteger.getAndIncrement());
        System.out.println(atomicInteger.get());
    }
}
