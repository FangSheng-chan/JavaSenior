package java并发实现原理.lock8;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @author fangsheng
 * @date 2021/7/7 6:17 下午
 */
public class EnhancedMap<K, V> {
    Map<K, V> map;

    public EnhancedMap(Map<K, V> map) {
        this.map = Collections.synchronizedMap(map);
    }

    public synchronized V putIfAbsent(K key, V value) {
        V old = map.get(key);
        if (old != null) {
            return old;
        }
        return map.put(key, value);
    }

//    public V putIfAbsent2(K key, V value) {
//        synchronized (map) {
//            V old = map.get(key);
//            if (old != null) {
//                return old;
//            }
//            return map.put(key, value);
//        }
//    }

    public V put(K key, V value) {
        return map.put(key, value);
    }

    public static void main(String[] args) {

        HashMap<Object, Object> map = new HashMap<>();
        Map<Object, Object> objectObjectMap = Collections.synchronizedMap(map);



        EnhancedMap<Object, Object> objectObjectEnhancedMap = new EnhancedMap<>(map);

        objectObjectEnhancedMap.putIfAbsent(1, 2);
    }
}
