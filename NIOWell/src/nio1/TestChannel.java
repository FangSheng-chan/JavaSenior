package nio1;

import org.junit.Test;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author fangsheng
 * @date 2021/5/25 6:09 下午
 */
public class TestChannel {
    public static void main(String[] args) {

    }

    /**
     * 写数据
     *
     * @throws IOException
     */
    @Test
    public void t1() throws IOException {
        String str = "hello,ss";
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("/Users/ss/Documents/code/test/t1.txt");
            //通过 FileOutputStream对应的FileChannel
            FileChannel fileChannel = fileOutputStream.getChannel();
            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
            byteBuffer.put(str.getBytes());
            byteBuffer.flip();
            //将ByteBuffer数据写入到FileChannel
            //此操作会不断移动 Buffer中的 position到 limit 的位置
            fileChannel.write(byteBuffer);
            fileChannel.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 读数据
     */
    @Test
    public void t2() throws IOException {
        File file = new File("/Users/ss/Documents/code/test/t1.txt");
        FileInputStream fileInputStream = new FileInputStream(file);
        FileChannel fileChannel = fileInputStream.getChannel();
        long length = file.length();
        System.out.println(length);
        ByteBuffer byteBuffer = ByteBuffer.allocate((int) length);
        fileChannel.read(byteBuffer);
        byte[] bytes = byteBuffer.array();
        System.out.println(new String(bytes));
        fileChannel.close();
    }

    /**
     * 读取
     */
    @Test
    public void t3() throws IOException {
        FileInputStream fileInputStream = new FileInputStream("1.txt");
        FileChannel fileChannel1 = fileInputStream.getChannel();

        FileOutputStream fileOutputStream = new FileOutputStream("2.txt");
        FileChannel fileChannel2 = fileOutputStream.getChannel();

        ByteBuffer byteBuffer = ByteBuffer.allocate(512);
        while (true) {
            //清空buffer，由于循环的最后执行了 write 操作，会将 position 移动到 limit 的位置
            //清空 Buffer的操作才为上一次的循环重置position的位置
            // 如果没有重置position，那么上次读取后，position和limit位置一样，读取后read的值永远为0
            byteBuffer.clear();
            //将数据存入 ByteBuffer，它会基于 Buffer 此刻的 position 和 limit 的值，
            // 将数据放入position的位置，然后不断移动position直到其与limit相等；
            int read = fileChannel1.read(byteBuffer);
            System.out.println("read=" + read);
            if (read == -1) { //表示读完
                break;
            }
            //将buffer中的数据写入到 FileChannel02 ---- 2.txt
            byteBuffer.flip();
            fileChannel2.write(byteBuffer);
        }
        //关闭相关的流
        fileInputStream.close();
        fileOutputStream.close();
    }

    @Test
    public void t4() throws Exception {
        FileInputStream fileInputStream = new FileInputStream("/Users/ss/Documents/code/test/GC2019.xmind");
        FileOutputStream fileOutputStream = new FileOutputStream("/Users/ss/Documents/code/test/ss.xmind");
        FileChannel source = fileInputStream.getChannel();
        FileChannel dest = fileOutputStream.getChannel();
        dest.transferFrom(source, 0, source.size());
        fileInputStream.close();
        fileOutputStream.close();
        source.close();
        dest.close();
    }
}

