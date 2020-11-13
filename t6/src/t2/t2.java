package t2;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class t2 {
    public static void main(String[] args) {
        Integer[] integers = {1,2,3};
        List<Integer> collect = Arrays.stream(integers).collect(Collectors.toList());
        collect.add(5);
        List<Integer> collect2 = collect.stream().filter(c -> c.equals(2)).collect(Collectors.toList());
        System.out.println(collect2);
        int[] myArray = {5,6,7};
        List<Integer> collect1 = Arrays.stream(myArray).boxed().collect(Collectors.toList());
        System.out.println(collect1);
    }
}
