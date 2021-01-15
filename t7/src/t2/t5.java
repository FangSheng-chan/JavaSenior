package t2;

import java.util.Objects;

public class t5 {
    public static void main(String[] args) {
//        Object 的 equals 方法容易抛出空指针异常，应使用常量或确定值的对象来调用 equals
        String str = null;

        if (Objects.equals(str, null)){
            System.out.println("yes----");
        }else {
            System.out.println("false----");
        }
    }
}
