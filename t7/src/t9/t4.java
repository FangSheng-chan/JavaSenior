package t9;

import org.junit.Before;
import org.junit.Test;
import org.w3c.dom.ls.LSOutput;

import javax.crypto.spec.PSource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author fangsheng
 * @date 2021/1/25 9:43 上午
 */
public class t4 {

    private Map<String, Object> map = new HashMap<>();

    @Before
    public void initData() {
        map.put("key1", "value1");
        map.put("key2", "value2");
        map.put("key3", "value3");
        map.put("key4", 4);
        map.put("key5", 5);
        map.put("key6", '6');
    }

    @Test
    public void test1() {
        Iterator<Map.Entry<String, Object>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Object> entry = iterator.next();
            Object value = iterator.next().getValue();
            if (entry.getValue().equals(5)) {
                iterator.remove();
            }
            System.out.println(entry.getValue());
        }
        System.out.println("--------------------------");
    }


    @Test
    public void test2() {
        for (Map.Entry<String, Object> entry : map.entrySet()) {

            System.out.println(entry.getKey() + entry.getValue());
        }
    }

    @Test
    public void test3() {
        for (String s : map.keySet()) {
            System.out.println("key=" + s + " and value=" + map.get(s));
        }
        map.values();
    }

    // foreach 和 iterator 区别就在于 remove
    @Test
    public void test4() {
        ArrayList<Object> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
        Iterator<Object> iterator = list.iterator();
        while (iterator.hasNext()) {
            Object next = iterator.next();
            System.out.println(next);
        }
    }
}
