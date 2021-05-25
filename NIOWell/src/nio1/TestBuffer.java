package nio1;

import org.junit.Test;

import java.nio.ByteBuffer;

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
        System.out.println("------");
        byte[] dst = new byte[byteBuffer.limit()];
        byteBuffer.get(dst);
        System.out.println("--------");
        System.out.println(new String(dst, 0, dst.length));
        System.out.println(byteBuffer.position());
        System.out.println(byteBuffer.limit());
        System.out.println(byteBuffer.capacity());
        System.out.println("--------");
        byteBuffer.rewind();
        System.out.println(byteBuffer.position());
        System.out.println(byteBuffer.limit());
        System.out.println(byteBuffer.capacity());
        System.out.println("--------");
        byteBuffer.clear();
        System.out.println(byteBuffer.position());
        System.out.println(byteBuffer.limit());
        System.out.println(byteBuffer.capacity());
        System.out.println((char) byteBuffer.get());
    }
}
