package java并发实现原理.chapter05;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @author fangsheng
 * @date 2021/6/22 3:52 下午
 */
public class CopyOnWriteDemo {
    public static void main(String[] args) {
        ConcurrentLinkedQueue<Object> concurrentLinkedQueue = new ConcurrentLinkedQueue<>();

    }

    private static void t1() {
        CopyOnWriteArrayList<Object> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
        copyOnWriteArrayList.add(1);
        System.out.println(copyOnWriteArrayList);
        CopyOnWriteArraySet<Object> copyOnWriteArraySet = new CopyOnWriteArraySet<>();
        copyOnWriteArraySet.add(1);
    }

    private static void ArrayListNotSafe2() {
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            new Thread(() -> {
                list.add(UUID.randomUUID().toString().substring(0, 8));
                System.out.println(list);
            }).start();
        }
    }

    /**
     * 会打印出来 null
     */
    private static void ArrayListNotSafe() {
        final List<Integer> list = new ArrayList<Integer>();

        // 线程A将0-1000添加到list
        new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                list.add(i);

                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        // 线程B将1000-2000添加到列表
        new Thread(() -> {
            for (int i = 1000; i < 2000; i++) {
                list.add(i);

                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 打印所有结果
        for (int i = 0; i < list.size(); i++) {
            System.out.println("第" + (i + 1) + "个元素为：" + list.get(i));
        }
    }
}
