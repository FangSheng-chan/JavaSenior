package t13;

import org.junit.Test;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

/**
 * @author fangsheng
 * @date 2021/5/17 9:49 上午
 */
public class T1 {
    public static void main(String[] args) {
        ByteBuffer byteBuffer = ByteBuffer.allocate(12);
        byteBuffer.putInt(1);
        byteBuffer.putInt(2);
        byteBuffer.putInt(3);
        byteBuffer.flip();
        byte[] array = byteBuffer.array();
        System.out.println(Arrays.toString(array));
    }


    @Test
    public void t1() {
        byte[] bytes = {2, 4, 8, 16};
        ByteBuffer buffer = ByteBuffer.wrap(bytes);
        while (buffer.hasRemaining()) {
            System.out.println(buffer.get());
        }

        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        byteBuffer.putInt(1);
        byteBuffer.putInt(2);
        byteBuffer.putInt(3);
        byteBuffer.putInt(4);
        byteBuffer.flip();
        while (byteBuffer.hasRemaining()) {
            System.out.println(buffer.get());
        }
    }

    public static int byteArrayToInt(byte[] paRawBytes, int piOffset, boolean pbBigEndian) {
        ByteOrder byteOrder = ByteOrder.LITTLE_ENDIAN;
        if (pbBigEndian) {
            byteOrder = ByteOrder.BIG_ENDIAN;
        }
        ByteBuffer byteBuffer = ByteBuffer.allocate(4).order(byteOrder);
        byteBuffer.put(paRawBytes, piOffset, 4);
        byteBuffer.flip();
        return byteBuffer.getInt();
    }
}
