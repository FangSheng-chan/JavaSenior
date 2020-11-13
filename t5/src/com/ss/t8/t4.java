package com.ss.t8;



import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.CharBuffer;

public class t4 {
    public static void main(String[] args) throws IOException {
        File file = new File("/Users/ss/Documents/test/s.txt");
        FileReader fileReader = new FileReader(file);
        CharBuffer charBuffer = CharBuffer.allocate(1024);
        fileReader.read(charBuffer);
        fileReader.close();
        System.out.println(new String(charBuffer.array()));

    }
}
