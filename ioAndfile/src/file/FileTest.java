package file;

import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**
 * @author fs
 * @date 2021/1/15 11:07 上午
 */
public class FileTest {
    @Test
    public void test1() {
        File file = new File("hellss.txt");
        if (!file.exists()) {
            try {
                file.createNewFile();
                System.out.println("创建文件");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            file.delete();
            System.out.println("删除文件");
        }
    }

    @Test
    public void test2() {
        File srcFile = new File("./");
        String[] fileNames = srcFile.list();
        for (String fileName : fileNames) {
            if (fileName.endsWith(".jpeg")) {
                System.out.println(fileName);
            }
        }
    }
    @Test
    public void test3 () {
        File file = new File("./");
        File[] files = file.listFiles();
        for (File srcFile : files) {
            String name = srcFile.getName();
        }
    }


}
