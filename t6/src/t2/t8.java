package t2;

import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;

public class t8 {
    public static void main(String[] args) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("z","b");
        hashMap.put("a","b");
        hashMap.put("c","b");
        hashMap.put("b","b");

        ArrayList<Integer> integers = new ArrayList<>();
//        integers.remove()

        Iterator<Map.Entry<String, String>> iterator = hashMap.entrySet().iterator();

        for (String key : hashMap.keySet()) {
            System.out.println(key);
//            System.out.println(hashMap.get(s));
        }

//        for (Map.Entry<String, String> stringEntry : hashMap.entrySet()) {
//            System.out.println(stringEntry.getKey()+stringEntry.getValue());
//        }

    }
}
