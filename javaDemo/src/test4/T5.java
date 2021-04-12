package test4;

/**
 * @author fangsheng
 * @date 2021/3/30 下午2:33
 */
public class T5 {
    public static void main(String[] args) {
        StringBuffer a = new StringBuffer("A");
        StringBuffer b = new StringBuffer("B");
        operator(a, b);
        System.out.println(a + "," + b);

        String x = "a";
        String y = "b";
        operator2(x, y);
        System.out.println(x + "," + y);
    }

    public static void operator(StringBuffer x, StringBuffer y) {
        x.append(y);
        y = x;
    }

    public static void operator2(String x, String y) {
        x =  new String("x");
        y = x;
    }
}
