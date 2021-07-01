package java并发实现原理.chapter05;

import org.junit.Test;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author fangsheng
 * @date 2021/6/23 2:16 下午
 */
public class ConcurrentHashMapDemo {
    public static void main(String[] args) {
        HashMap<Object, Object> map = new HashMap<>();
        ConcurrentHashMap<Object, Object> concurrentHashMap = new ConcurrentHashMap<>();
        AtomicInteger atomicInteger = new AtomicInteger();
    }
    /**
     * |=：两个二进制对应位都为0时，结果等于0，否则结果等于1；
     * &=：两个二进制的对应位都为1时，结果为1，否则结果等于0；
     * ^=：两个二进制的对应位相同，结果为0，否则结果为1。
     */
    @Test
    public void t1(){
        int a = 5;
        int b = 3;
        a &= b;
        System.out.println(a);
    }
    @Test
    public void t2(){
        int a = 5;
        int b = 3;
        a = a|b;
        System.out.println(a);
    }
}
