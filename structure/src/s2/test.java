package s2;

import java.util.Arrays;
import java.util.List;

/**
 * @author fangsheng
 * @date 2021/3/2 上午9:49
 */
public class test {
    public static void main(String[] args) {
        String s = "1,2,3";
        String[] split = s.split(",");
        test test = new test();
        StringBuilder s1 = test.test2(split);
        System.out.println(s1);
    }
    public StringBuilder test2( String[] split){
        StringBuilder sb = new StringBuilder();
        for (String s : split) {
            if (s.equals("2")){
                return null;
            }else {
                sb.append(s);
            }
        }
        return sb;
    }
}
