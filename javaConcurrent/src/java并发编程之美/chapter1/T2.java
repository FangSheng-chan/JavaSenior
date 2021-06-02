package java并发编程之美.chapter1;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @author fangsheng
 * @date 2021/5/29 5:38 下午
 */
public class T2 {
    public static void main(String[] args) {
        int maxValue = Integer.MAX_VALUE;
        BlockingQueue<Object> queue = new ArrayBlockingQueue(2);
        synchronized (queue) {
            while (queue.size() == maxValue){
                try {
                    queue.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }


}
