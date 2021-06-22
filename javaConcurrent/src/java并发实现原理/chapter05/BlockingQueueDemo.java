package java并发实现原理.chapter05;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author fangsheng
 * @date 2021/6/21 4:17 下午
 */
public class BlockingQueueDemo {
    public static void main(String[] args) {
        BlockingQueue<Object> blockingQueue = new ArrayBlockingQueue<Object>(10);
        LinkedBlockingQueue<Object> linkedBlockingQueue = new LinkedBlockingQueue<>();
    }
}
