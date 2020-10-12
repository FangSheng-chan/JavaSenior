package t1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class e1 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>(Arrays.asList("a", "b", "c"));
        System.out.println(list);

        Integer[] myArray = {1,2,3};
        List<Integer> collect = Arrays.stream(myArray).collect(Collectors.toList());
        System.out.println(collect);
        for (Integer integer : myArray) {
            System.out.println(integer);
        }

        Object i = 3;
        Object object = 3;
        String s = i.toString();
        String s1 = String.valueOf(i);
        String s2 = (String)(object);
        System.out.println(s);
        System.out.println(s1);
        System.out.println(s2);

    }
}
