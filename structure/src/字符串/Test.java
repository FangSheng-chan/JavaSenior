package 字符串;

import java.util.Arrays;
import java.util.List;

/**
 * @author fangsheng
 * @date 2021/5/24 11:17 上午
 */
public class Test {
    public static void main(String[] args) {
        String[] strings = {"flower", "flow", "flight"};
        Arrays.sort(strings);
        System.out.println(Arrays.asList(strings));
    }
}
