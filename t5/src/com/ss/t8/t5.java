package com.ss.t8;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class t5 {
    public static void main(String[] args) throws IOException {
        File file = new File("/Users/ss/Documents/test/s.txt");
        FileInputStream fileInputStream = new FileInputStream(file);
        FileChannel fileInputStreamChannel = fileInputStream.getChannel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);




        byteBuffer.putInt(8888);

        fileInputStreamChannel.read(byteBuffer);
        fileInputStream.close();
        System.out.println(new String(byteBuffer.array()));
    }
}
