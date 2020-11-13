package t2;

import java.util.ArrayList;

public class t4 {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        list.removeIf(filter -> filter % 2 == 0);
        System.out.println(list);
    }
}
