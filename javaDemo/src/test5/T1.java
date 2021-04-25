package test5;

import java.util.Arrays;
import java.util.Optional;

/**
 * @author fangsheng
 * @date 2021/4/13 下午2:31
 */
public class T1 {
    public static void main(String[] args) {
        Emp emp = null;
        Optional<Emp> s1 = Optional.ofNullable(emp);
        String name = s1.orElse(new Emp("unKnow")).getName();
        System.out.println(name);
    }
}
