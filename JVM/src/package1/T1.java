package package1;

import org.junit.Test;

import java.util.HashMap;
import java.util.Stack;

/**
 * 1、new String都是在堆上创建字符串对象，当调用intern()方法时，编译器会将字符串添加到常量池中（stringTable维护），并返回指向该常量的引用
 *
 * @author fangsheng
 * @date 2021/6/2 1:45 下午
 */
public class T1 {
    public static void main(String[] args) {
        String str2 = new String("str") + new String("01");
        String str1 = "str01";
        String str3 = str2.intern();
        System.out.println(str2 == str1);
        System.out.println(str3 == str1);
        System.out.println(str3 == str2);

        Person p = new Person();
        p.setSex("男");
    }

    @Test
    public void t1() {
        String s1 = "abc";
        String s2 = "a";
        String s3 = "bc";
        String s4 = s2 + s3;
        String s5 = "a" + "bc";
        System.out.println(s1 == s4);
        System.out.println(s1 == s5);
    }

    @Test
    public void t2(){
        HashMap<Object, Object> hashMap = new HashMap<>();
        Stack<Object> objects = new Stack<>();
    }
}
