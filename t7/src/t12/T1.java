package t12;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

/**
 * @author fangsheng
 * @date 2021/5/12 12:44 下午
 */
public class T1 {

    Map<String, BlockingQueue<String>> map = new ConcurrentHashMap<>();

    public String take(String key) {
        String message = null;
        if (!map.containsKey(key)) {
            map.put(key, new ArrayBlockingQueue<>(10));
        }
        try {
            System.out.println(map.get(key).size());
            for (int i = 0; i < map.get(key).size(); i++) {
                String poll = map.get(key).poll(1, TimeUnit.SECONDS);
                System.out.println(poll);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return message;
    }

    public static void main(String[] args) {
        T1 t1 = new T1();
        Map<String, BlockingQueue<String>> map = t1.map;
        ArrayBlockingQueue<String> queue = new ArrayBlockingQueue<>(10);
        try {
            queue.put("value---1");
            queue.put("value---2");
            queue.put("value---5");
            queue.put("value---3");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(queue);
        map.put("1", queue);
        t1.take("1");
    }

}










