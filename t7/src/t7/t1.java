package t7;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class t1 {
    public static void main(String[] args) {
        /***
         * 1、当链表长度大于阈值（默认为8）时，将链表转化为红黑树（将链表转换为红黑树前会判断，如果当前数组的长度小于64，
         * 那么会选择先进行数组扩容，而不是转换为红黑树），以减少搜索时间
         * 2、JDK1.8之前HashMap底层是数组加链表结合在一起使用也就是链表散列。
         */
        HashMap<Object, Object> hashMap = new HashMap<>();

        Set<Map.Entry<Object, Object>> entries = hashMap.entrySet();

        Set<Object> objects = hashMap.keySet();
        for (Object object : objects) {
            System.out.println(object);
        }

        int h = 8;

        int i = h >> 2;
        int j = h >> 1;

//        System.out.println(i);
//        System.out.println(j);
//
//        h ^= (h >> 2) ^ (h >> 1);
//
//
//        System.out.println(h);
//
//        System.out.println(Float.isNaN(8));

        Integer a ;
        Integer b = 126;
        int[] c = {};
        System.out.println((a = b) == null);
    }
}
