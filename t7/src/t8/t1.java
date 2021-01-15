package t8;

import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 * Created by fangsheng on 2021/1/7 3:50 下午
 */
public class t1 {
    public static void main(String[] args) {

    }

    @Test
    public void test1(){
        File file = new File("/Users/ss/Pictures/photos/ss.jpeg");
        try {
            FileOutputStream fos = new FileOutputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test2() {
        try {
            FileOutputStream fos = new FileOutputStream("/Users/ss/Pictures/photos/ss.jpeg");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test3(){
        File file = new File("/Users/ss/Documents/test/1.txt");
        try {
            FileOutputStream fos = new FileOutputStream(file, true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
