package t2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class t2 {
    public static void main(String[] args) {
        String s = "ss";

        Integer[] array = {1, 2, 3};
        List<Integer> integerList = Arrays.stream(array).collect(Collectors.toList());
        integerList.remove(1);
        System.out.println(integerList);

        ArrayList<String> arrayList = new ArrayList<>(Arrays.asList("a", "b"));

    }

    static <T> List<T> arrayToList(final T[] array) {
        final List<T> list = new ArrayList<>(array.length);

        for (final T t : array) {
            list.add(t);
        }
        return list;
    }
}
