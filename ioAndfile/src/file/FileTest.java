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
        if (!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
