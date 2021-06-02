package nio1;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;

/**
 * 一、缓冲区(Buffer)：在Java NIO 中负责数据的存取。缓冲区就是数组。用于存储不同数据类型的数据
 * 二、缓冲区的核心方法
 * put()
 * get()
 * 三、缓冲区的四个核心属性
 * capacity：容量，表示缓冲区中最大存储数据的容量，一旦声明不能改变
 * limit：界限，表示缓冲区中可以操作数据的大小。（limit后数据不能进行读写）
 * position：位置，表示缓冲区正在操作数据的位置
 * <p>
 * position <= limit <= capacity
 *
 * @author fangsheng
 * @date 2021/5/12 11:16 下午
 */
public class TestBuffer {
    @Test
    public void t1() {
        String s = "abcde";
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        System.out.println(byteBuffer.position());
        System.out.println(byteBuffer.limit());
        System.out.println(byteBuffer.capacity());
        System.out.println("------");
        byteBuffer.put(s.getBytes());
        System.out.println(byteBuffer.position());
        System.out.println(byteBuffer.limit());
        System.out.println(byteBuffer.capacity());
        System.out.println("------");
        byteBuffer.flip();
        System.out.println(byteBuffer.position());
        System.out.println(byteBuffer.limit());
        System.out.println(byteBuffer.capacity());
        byte[] dst = new byte[byteBuffer.limit()];
        byteBuffer.get(dst);
        System.out.println("--------");
        System.out.println(new String(dst, 0, dst.length));
        System.out.println(byteBuffer.position());
        System.out.println(byteBuffer.limit());
        System.out.println(byteBuffer.capacity());
        System.out.println("rewind--------");
        byteBuffer.rewind();
        System.out.println(byteBuffer.position());
        System.out.println(byteBuffer.limit());
        System.out.println(byteBuffer.capacity());
        System.out.println("clear--------");
        byteBuffer.clear();
        System.out.println(byteBuffer.position());
        System.out.println(byteBuffer.limit());
        System.out.println(byteBuffer.capacity());
        System.out.println((char) byteBuffer.get());
    }

    @Test
    public void t2() {
        IntBuffer buffer = IntBuffer.allocate(5);
        for (int i = 0; i < buffer.capacity(); i++) {
            //向buffer存放数据
            buffer.put(i * 2);
        }
        //取数据
        buffer.flip();
        while (buffer.hasRemaining()) {
            System.out.println(buffer.get());
        }
    }

    @Test
    public void t3() {
        ByteBuffer buffer = ByteBuffer.allocate(24);
        //int占 4byte
        buffer.putInt(100);
        //long占 8byte
        buffer.putLong(20);
        //double占 8byte
        buffer.putDouble(30);
        //char占 2byte
        buffer.putChar('上');
        //short占 2byte
        buffer.putShort((short) 44);
        buffer.flip();
        System.out.println(buffer.getInt());
        System.out.println(buffer.getLong());
        System.out.println(buffer.getChar());
        System.out.println(buffer.getShort());
    }

    @Test
    public void t4() {
        ByteBuffer buffer = ByteBuffer.allocate(2);
        buffer.put(new byte[2]);
    }

    @Test
    public void t5() {
        ByteBuffer byteBuffer = ByteBuffer.allocate(64);
        for (int i = 0; i < 64; i++) {
            byteBuffer.put((byte) i);
        }
        byteBuffer.flip();
        ByteBuffer readOnlyBuffer = byteBuffer.asReadOnlyBuffer();
        System.out.println(readOnlyBuffer.getClass());
        while (readOnlyBuffer.hasRemaining()) {
            System.out.println(readOnlyBuffer.get());
        }
    }

    @Test
    public void t6() {
        try {
            FileInputStream fileInputStream = new FileInputStream("1.txt");
            StringBuffer stringBuffer = new StringBuffer();
            int result = 0;
            while (result != -1) {
                try {
                    result = fileInputStream.read();
                    char n1 = (char) result;
                    stringBuffer.append(n1);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(stringBuffer.toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void t7(){
        byte[] bytes = new byte[32];
        ByteBuffer byteBuffer = ByteBuffer.wrap(bytes);
        byteBuffer.put((byte) 1);
        byteBuffer.put((byte) 2);
        byteBuffer.flip();
        while (byteBuffer.hasRemaining()){
            System.out.println(byteBuffer.get());
        }
    }

}
