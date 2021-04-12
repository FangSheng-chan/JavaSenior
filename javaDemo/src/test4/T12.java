package test4;

/**
 * 引用对象的值发生改变，该对象的值也会发生改变。要想不改变，在传参（传地址）过去的时候只能使这个地址指向一个新的对象。
 */

/**
 * @author fangsheng
 * @date 2021/4/4 上午12:26
 */
public class T12 {
    public static void main(String[] args) {
        int i = 1;
        T12 s1 = new T12();
        fun1(i);
        System.out.println(i);
        String ss = "main";
        System.out.println(ss);
        fun3(ss);
        System.out.println(ss);
        fun4(ss);
        System.out.println(ss);
    }

    //基本类型的参数传递
    public static void fun1(int m) {
        m = 100;
    }

    //参数为对象，不改变引用的值
    public static void fun2(StringBuffer s) {
        s.append("fun2");
    }

    //参数为对象，改变引用的值
    public static void fun3(String s) {
        s = new String("fun3");
    }

    public static void fun4(String s) {
        s = "fun4";
    }
}
