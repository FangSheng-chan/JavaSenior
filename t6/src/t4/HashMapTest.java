package t4;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class HashMapTest {
    public static void main(String[] args) {
        // 创建并赋值 HashMap
        Map<Integer, String> map = new HashMap();
        map.put(1, "Java");
        map.put(2, "JDK");
        map.put(3, "Spring Framework");
        map.put(4, "MyBatis framework");
        map.put(5, "Java中文社群");
        // 遍历
//        map.entrySet().stream().forEach((entry) -> {
//            System.out.println(entry.getKey());
//            System.out.println(entry.getValue());
//        });

        List<String> stringList = map.entrySet().stream()
                .filter(integerStringEntry -> integerStringEntry.getValue().length() > 3)
                .map(Map.Entry::getValue).collect(Collectors.toList());

        System.out.println(stringList);


    }
}
