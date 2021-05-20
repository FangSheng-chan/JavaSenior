package com.ss.t8.utils;

import com.sun.org.apache.xerces.internal.impl.dv.util.HexBin;
import org.apache.commons.codec.binary.Hex;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/**
 * @author fangsheng
 * @date 2021/5/17 10:04 上午
 */
public class ByteUtil {

    public static void main(String[] args) {
        int i = 1005;
        byte[] bytes = intToByteArray(i, true);
        System.out.println(Hex.encodeHex(bytes));
    }

    /**
     * Converts int value to a byte array
     *
     * @param piValueToConvert the original integer
     * @param pbBigEndian      true if the bytes are in Big-endian order; false otherwise
     * @return byte[] representation of the int
     */
    public static byte[] intToByteArray(int piValueToConvert, boolean pbBigEndian) {
        ByteOrder byteOrder = ByteOrder.LITTLE_ENDIAN;
        if (pbBigEndian) {
            byteOrder = ByteOrder.BIG_ENDIAN;
        }
        ByteBuffer byteBuffer = ByteBuffer.allocate(4).order(byteOrder);
        byteBuffer.putInt(piValueToConvert);
        byteBuffer.flip();
        return byteBuffer.array();
    }
}

