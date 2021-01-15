package t8;

import java.io.*;

/**
 * Created by fangsheng on 2021/1/7 3:59 下午
 */
public class FileStream {
    public static void main(String[] args) {
        try {
            readFile3();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readFile() throws IOException {
        InputStream input = null;
        try {
            input = new FileInputStream("src/readme.txt");
            int n;
            // 利用while同时读取并判断
            while ((n = input.read()) != -1) {
                System.out.println(n);
            }
        } finally {
            if (input != null) { input.close(); }
        }
    }

    public void readFile2() throws IOException {
        try (InputStream input = new FileInputStream("src/readme.txt")) {
            int n;
            while ((n = input.read()) != -1) {
                System.out.println(n);
            }
        } // 编译器在此自动为我们写入finally并调用close()
    }

    public static void readFile3() throws IOException {
        try (InputStream input = new FileInputStream("/Users/ss/Pictures/photos/ss.jpeg")) {
            // 定义1000个字节大小的缓冲区:
            byte[] buffer = new byte[1000];
            int n;
            // 读取到缓冲区
            while ((n = input.read(buffer)) != -1) {
                System.out.println("read " + n + " bytes.");
            }
        }
    }
}