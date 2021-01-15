package t2;

import java.util.ArrayList;
import java.util.Iterator;

public class t4 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.ensureCapacity(20);
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()){
            String item = iterator.next();
            if (item.equals("a")){
                iterator.remove();
            }
        }
        System.out.println(list);
    }
}
