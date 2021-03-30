package test3;

import org.junit.Test;

import java.io.*;
import java.util.ArrayList;

/**
 * @author fangsheng
 * @date 2021/2/26 下午4:29
 */
public class t1 {

    @Test
    public void test1() {
        String s = "abcdccg";
        String substring = s.substring(0, 1);
        System.out.println(substring);

//        FileInputStream fileInputStream = new FileInputStream();
//        new OutputStreamWriter()
        File file = new File("");
        boolean exists = file.exists();
        System.out.println(exists);



    }

    public static void main(String[] args) {
        long round = Math.round(-1.5);
        System.out.println(round);

        String s = "abcdefg";
        int index = s.indexOf("a");
        System.out.println(index);


        StringBuilder stringBuilder = new StringBuilder("123");
        StringBuilder append = stringBuilder.append("123");
        stringBuilder.reverse();
        System.out.println(append);
    }


}
