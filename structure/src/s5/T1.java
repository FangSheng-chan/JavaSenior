package s5;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Vector;

/**
 * @author fangsheng
 * @date 2021/3/17 上午10:04
 */
public class T1 {
    HashMap<Integer, Integer> valToIndex = new HashMap<>();
    Vector<Integer> nums = new Vector();

    boolean insert(int val) {
        if (valToIndex.containsValue(val)) {
            return false;
        }
        int size = nums.size();
        valToIndex.put(size+1, size+1);
        nums.add(val);
        return true;
    }

    boolean remove(int val) {
        if (!valToIndex.containsValue(val)) {
            return false;
        }
        Integer index = valToIndex.get(val);
        Integer lastElement = nums.lastElement();
        valToIndex.put(valToIndex.get(lastElement), index);
        swap(nums.get(index), nums.lastElement());
        nums.remove(nums.lastElement());
        valToIndex.remove(val);
        return true;
    }

    void swap(int x, int y) {
        int temp;
        temp = x;
        x = y;
        y = temp;
    }

     void print(){
        for (Integer num : nums) {
            System.out.println(num);
        }
    }
    public static void main(String[] args) {
//        HashMap<Integer, Integer> map = new HashMap<>();
//        HashSet<Object> hashSet = new HashSet<>();
//        map.put(1, 1);
//        map.put(2, 2);
//        map.put(3, 3);
//        map.put(4, 4);
//        map.put(5, 5);
//        boolean b = map.containsValue(5);
//        System.out.println(b);
        T1 t1 = new T1();
        t1.insert(1);
        t1.insert(2);
        t1.remove(1);
        t1.print();
    }
}
