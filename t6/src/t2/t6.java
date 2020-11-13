package t2;

import java.util.ArrayList;
import java.util.List;

public class t6 {
    public static void main(String[] args) {
        List<String> objects = new ArrayList<>();
        objects.add("222");
        objects.add(1, "333");
        objects.add(2, "444");
        for (int i = 0; i < objects.size(); i++) {
            if (objects.get(i).equals("333")) {
                objects.add(i + 1, "555s");
            }
        }

        System.out.println(objects);
    }
}
