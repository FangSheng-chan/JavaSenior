package 双指针;

import java.util.HashMap;

/**
 * @author fangsheng
 * @date 2021/6/10 10:22 上午
 */
public class T2 {
    public static void main(String[] args) {
        HashMap<Object, Object> map = new HashMap<>();
        Object o1 = map.get("1");
        Object o2 = map.getOrDefault("1", 1);
        System.out.println(o1);
        System.out.println(o2);
    }
}
