package test1;

import java.util.*;

/**
 * @author fangsheng
 * @date 2021/3/1 下午3:20
 */
public class T4 {
    public static void main(String[] args) {
        int[] array = new int[3];
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }

        List<String> list = Arrays.asList("1", "2", "3");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        System.out.println("--------");

        HashMap<Object, Object> hashMap = new HashMap<>();
        hashMap.put("1", "1");
        hashMap.put("2", "1");
        hashMap.put("3", "1");
        hashMap.put("4", "1");
        hashMap.put("5", "1");
        for (Object o : hashMap.keySet()) {
            System.out.println(o);
            System.out.println(hashMap.get(o));
        }

        Iterator<Map.Entry<Object, Object>> iterator = hashMap.entrySet().iterator();


        HashSet<Object> objectHashSet = new HashSet<>();
        Iterator<Object> iterator1 = objectHashSet.iterator();


//        for (String s : list) {
//            if (s.equals("1")) {
//                list.remove(s);
//            }
//        }

        ListIterator<String> stringListIterator = list.listIterator();
        while (stringListIterator.hasNext()) {

        }
//        Iterator<String> iterator = list.iterator();
//        while (iterator.hasNext()) {
//            String next = iterator.next();
//            if (next.equals("1")) {
//                list.remove(next);
//            }
//        }
    }
}
