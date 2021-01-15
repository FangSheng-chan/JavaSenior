package t6;

import java.util.ArrayList;

public class test03 {
    public static void main(String[] args) {

        ArrayList<Object> objects = new ArrayList<>();
        objects.add(1);
        objects.add(2);
        objects.add(3);
        objects.add(4);
        Object remove = objects.remove(2);
        System.out.println(remove);
    }
}
