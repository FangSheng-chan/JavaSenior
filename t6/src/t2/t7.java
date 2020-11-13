package t2;

import java.util.*;

public class t7 {
    public static void main(String[] args) {
        TreeMap<String, String> treeMap = new TreeMap<>();
        treeMap.put("z","b");
        treeMap.put("a","b");
        treeMap.put("c","b");
        treeMap.put("b","b");
        treeMap.put("a","b");
        Set<String> strings = treeMap.keySet();
        for (String string : strings) {
            System.out.println(string);
        }
        
    }
}
