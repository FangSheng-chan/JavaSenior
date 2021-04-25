package ArrayList不安全_4;

import org.junit.Test;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * CopyOnWriteArraySet:底层是用 CopyOnWriteArrayList
 * HashSet:底层结构就是HashMap
 */

/**
 * @author fangsheng
 * @date 2021/4/23 下午3:11
 */
public class ArrayListNotSafeDemo {
    public static void main(String[] args) {
//        CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();
//        // java.util.ConcurrentModificationException
//        for (int i = 0; i < 30; i++) {
//            new Thread(() -> {
//                list.add(UUID.randomUUID().toString().substring(0, 8));
//                System.out.println(list);
//            }).start();
//        }

        Map<String, String> map = new ConcurrentHashMap<>();
        for (int i = 0; i < 30; i++) {
            new Thread(() -> {
                map.put(Thread.currentThread().getName(), UUID.randomUUID().toString().substring(0, 8));
                System.out.println(map);
            }, String.valueOf(i)).start();
        }
    }

    @Test
    public void t1() {
        int[] ints = {1, 2, 3};
        int[] ints1 = Arrays.copyOf(ints, ints.length + 1);
        System.out.println(Arrays.toString(ints1));
        ints1[ints.length] = 4;
        System.out.println(Arrays.toString(ints1));
    }

    @Test
    public void t2() {
        CopyOnWriteArraySet<Object> copyOnWriteArraySet = new CopyOnWriteArraySet<>();
        copyOnWriteArraySet.add(1);
        copyOnWriteArraySet.add(2);

        System.out.println(add());

    }

    public static boolean add() {
        HashMap<Object, Object> hashMap = new HashMap<>();
        return hashMap.put(null, null) == null;
    }


    @Test
    public void t3() {
        HashMap<String, String> map = new HashMap<>();
        for (int i = 0; i < 30; i++) {
            new Thread(() -> {
                map.put(Thread.currentThread().getName(), UUID.randomUUID().toString().substring(0, 8));
                System.out.println(map);
            }, String.valueOf(i)).start();
        }
    }
}
