package test1;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author fangsheng
 * @date 2021/3/2 下午2:03
 */
public class T5 {
    public static void main(String[] args) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("1", "1");
        hashMap.put("2", "1");
        hashMap.put("3", "1");
        hashMap.put("4", "1");
        hashMap.put("5", "1");
        Set<Map.Entry<String, String>> entries = hashMap.entrySet();
        for (Map.Entry<String, String> stringStringEntry : hashMap.entrySet()) {
            System.out.println(stringStringEntry.getValue());
            System.out.println(stringStringEntry.getKey());
        }
        System.out.println("------------");
        Set<String> strings = hashMap.keySet();
        for (String string : strings) {
            System.out.println(hashMap.get(string));
            System.out.println(string);
        }

        Phone phone = new Phone();
        FutureTask futureTask = new FutureTask<>(phone);
        new Thread(futureTask).start();
        try {
            Object o = futureTask.get();
            System.out.println(o);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}

class Phone implements Callable<String> {
    @Override
    public String call() throws Exception {
        return "fangsheng";
    }
}

class Car implements Runnable {
    @Override
    public void run() {

    }
}
