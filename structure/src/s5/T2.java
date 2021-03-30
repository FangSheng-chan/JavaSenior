package s5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * @author fangsheng
 * @date 2021/3/22 下午2:49
 */
public class T2 {
    public static void main(String[] args) {
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        hashMap.put(2,2);
//        hashMap.put(3,3);
//        hashMap.put(1,1);
//        hashMap.put(4,4);
//        hashMap.put(5,5);
//        hashMap.put(6,6);
//        hashMap.put(65536,65536);
//
//        for (Integer s: hashMap.keySet()) {
//            System.out.print(hashMap.get(s) + " ");
//        }

        int hash = hash("方胜");
        System.out.println(hash);

        LinkedList<Object> objects = new LinkedList<>();
        objects.add("123");

        ArrayList<Object> list = new ArrayList<>();
        list.add("q23");
    }

    static final int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }
}
