package t7;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class t2 {
    public static void main(String[] args) {
        Map<String, Object> map = new HashMap<>();
        map.put("key1", "value1");
        map.put("key2", "value2");
        map.put("key3", "value3");
        map.put("key4", 4);
        map.put("key5", 5);
        map.put("key5", 'h');

        for (String key : map.keySet()) {
            System.out.println(key + map.get(key));
        }

        for (Map.Entry<String, Object> entry : map.entrySet()) {
            System.out.println(entry.getKey() + entry.getValue());
        }

        Iterator<Map.Entry<String, Object>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Object> entry = iterator.next();
            System.out.println(entry.getKey() + entry.getValue());
        }

    }
}
