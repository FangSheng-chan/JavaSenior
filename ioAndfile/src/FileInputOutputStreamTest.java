import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author fs
 * @date 2021/1/13 12:23 下午
 */
public class FileInputOutputStreamTest {
    @Test
    public void testFileInputOutputStream() {
    }

    @Test
    public void test02() {
        long start = System.currentTimeMillis();
        copyFile("", "");
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }



    public static void copyFile(String srcFileName, String destFileName) {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            File srcFile = new File(srcFileName);
            File destFile = new File(destFileName);
            byte[] buffer = new byte[1024];
            int len;
            fis = new FileInputStream(srcFile);
            fos = new FileOutputStream(destFile);
            while (((len = fis.read(buffer)) != -1)) {
                fos.write(buffer, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
