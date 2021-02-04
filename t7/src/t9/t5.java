package t9;

import java.util.Optional;

/**
 * @author fangsheng
 * @date 2021/1/25 3:13 下午
 */
public class t5 {
    public static void main(String[] args) {
        String s = "";
        if (s == ""){
            s = "";
        }else {
            String s2 = "1".equals(s) ? "注意" : "警告";
            System.out.println(s2);
        }



        Optional<String> s1 = Optional.ofNullable(s);
        System.out.println(String.valueOf(s1));
    }
}
