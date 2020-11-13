package t2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class t1 {
    public static void main(String[] args) {
        String[] strings = {"ss","dd","ff"};
        //将数组转集合
        List<String> stringList= Arrays.asList(strings);
        String collect = stringList.stream().filter(s -> s.length() < 5).sorted().map(s -> s+"zz").collect(Collectors.joining("99"));
        System.out.println(collect);


        ArrayList<String> stringArrayList = new ArrayList<>(Arrays.asList(strings));
        stringArrayList.add("xx");
        System.out.println(stringArrayList);

    }
}
