package t8;

/**
 * Created by fangsheng on 2021/1/7 4:05 下午
 */

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * new FileOutputStream("a.txt",true);  第二个参数true，设置为写入的数据拼接在尾部
 * \n\r 换行
 * write(bys,1,3);  写入字节数组
 */
public class out {
    public static void main(String args[]) {
        FileOutputStream outputStream = null;
        try {
            outputStream = new FileOutputStream("a.txt", true);
            /*
             * 创建字节输出流对象了做了几件事情：
             * A:调用系统功能去创建文件
             * B:创建outputStream对象
             * C:把foutputStream对象指向这个文件
             */

//            for (int i = 0; i <5 ; i++) {
//                outputStream.write("hello".getBytes());
//                outputStream.write("\n\r".getBytes());
//            }
            byte[] bys = {97, 98, 99, 100, 101};
            outputStream.write(bys, 1, 3);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
}


