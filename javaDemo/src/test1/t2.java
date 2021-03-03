package test1;

import java.util.*;

/**
 * @author fangsheng
 * @date 2021/3/1 下午1:50
 */
public abstract class t2 {

    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<>();
        List<String> list = Arrays.asList("1", "2", "3");
        queue.offer("1");
        String remove = queue.remove();
        System.out.println(remove);

//        for (String s : queue) {
//            System.out.println(s);
//        }
        int i = Collections.binarySearch(list, "2");
//        System.out.println(i);
        HashSet<String> strings = new HashSet<>();
        strings.add("ss");
        strings.add("ss");
        for (String string : strings) {
            System.out.println(string.hashCode());
            System.out.println("----------");
            System.out.println(string);
        }
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("12", "34");
        Set<Map.Entry<String, String>> entries = hashMap.entrySet();
        Iterator<Map.Entry<String, String>> iterator = entries.iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, String> next = iterator.next();
            String value = next.getValue();
            System.out.println(value);
        }
//        new TreeMap<>()
    }

    private String ss = "ss123";

    abstract void send();

    String get() {
        return ss;
    }
}

