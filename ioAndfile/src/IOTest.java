import org.junit.Test;

import java.io.*;
import java.util.HashMap;

/**
 * Created by fangsheng on 2021/1/8 3:01 下午
 */
public class IOTest {

    @Test
    public void test1() throws IOException {
        HashMap<Object, Object> hashMap = new HashMap<>();
        FileReader fr = new FileReader("hello");
        int read;
        while ((read = fr.read()) != -1) {
            System.out.print((char) read);
        }
        fr.close();
    }

    @Test
    public void test2() throws IOException {
        FileReader fr = null;
        try {
            File file = new File("hello.txt");
            fr = new FileReader(file);
            char[] chars = new char[5];
            int len;
            while ((len = fr.read(chars)) != -1) {

                for (int i = 0; i < len; i++) {
                    System.out.print(chars[i]);
                }
            }

            while ((len = fr.read(chars)) != -1) {
                String s = new String(chars, 0, len);
                System.out.print(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fr != null) {
                try {
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void test3(){
        System.out.println("1589446387003".length());
    }
}
