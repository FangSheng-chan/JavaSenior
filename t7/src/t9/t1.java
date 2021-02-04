package t9;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.Date;

/**
 * @author fangsheng
 * @date 2021/1/20 4:48 下午
 */
public class t1 {

    @Test
    public void test1() throws IOException {
        File file = new File("/Users/ss/Documents/test/" + "1.txt");
        System.out.println(file.createNewFile());
    }

    @Test
    public void test2() throws IOException {
        File file1 = new File("hello.txt");
        File file2 = new File("d:\\io\\hi.txt");

        System.out.println(file1.getAbsolutePath());
        System.out.println(file1.getPath());
        System.out.println(file1.getName());
        System.out.println(file1.getParent());
        System.out.println(file1.length());
        System.out.println(new Date(file1.lastModified()));
        System.out.println(file1.createNewFile());
        System.out.println(file1.length());

        System.out.println();

        System.out.println(file2.getAbsolutePath());
        System.out.println(file2.getPath());
        System.out.println(file2.getName());
        System.out.println(file2.getParent());
        System.out.println(file2.length());
        System.out.println(file2.lastModified());
        System.out.println(file1.createNewFile());
    }

    @Test
    public void test3() {
        String path = t1.class.getResource("/").getPath();
        File file = new File(path);

        String[] list = file.list();
        for (String s : list) {
            System.out.println(s);
        }

        System.out.println();

        File[] files = file.listFiles();
        for (File f : files) {
            System.out.println(f);
        }

    }

    @Test
    public void test4(){
        File file1 = new File("hello.txt");
        System.out.println(file1.renameTo(new File("ss.txt")));
    }

    public static String getPath() {
        return t1.class.getResource("/").getPath();
    }

    @Test
    public void test5() {
        File file = new File("/Users/ss/Documents/test");
        boolean mkdir = file.mkdir();
        if (mkdir){
            System.out.println("创建成功");
        }else {
            System.out.println("已有文件");
        }
        System.out.println("sss");
    }
}
