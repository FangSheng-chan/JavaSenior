package t2;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class t3 {
    public static void main(String[] args) {
        String[] strings = new String[]{"dog", "lazy", "over"};
        List<String> stringList = Arrays.asList(strings);
        Collections.reverse(stringList);
        strings = stringList.toArray(new String[0]);
        for (String string : strings) {
            System.out.println(string);
        }
    }
}
