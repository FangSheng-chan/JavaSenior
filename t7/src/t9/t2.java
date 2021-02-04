package t9;

import org.junit.Test;

import java.io.File;

/**
 * @author fangsheng
 * @date 2021/1/21 10:46 上午
 */
public class t2 {


    @Test
    public void test1() {
        File file = new File("/Users/ss/Documents/test", "/pdf");
        System.out.println(getDirSize(file));
    }

    public static void printSubFile(File dir) {
        File[] files = dir.listFiles();
        for (File file : files) {
            if (file.isDirectory()) {
                printSubFile(file);
            } else {
                System.out.println(file.getAbsolutePath());
            }
        }
    }

    public static long getDirSize(File file) {
        int size = 0;
        if (file.isFile()) {
            size += file.length();
        } else {
            File[] files = file.listFiles();
            for (File f : files) {
                size += getDirSize(f);
            }
        }
        return size;
    }

    public static void delDir(File file) {
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            for (File f : files) {
                delDir(f);
            }
        } else {
            file.delete();
        }
    }
}
