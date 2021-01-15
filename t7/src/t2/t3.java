package t2;

import java.util.ArrayList;
import java.util.List;

public class t3 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= 10; ++i) {
            list.add(i);
        }
        list.removeIf(filter -> filter % 2 == 0);
        System.out.println(list);
    }
}
