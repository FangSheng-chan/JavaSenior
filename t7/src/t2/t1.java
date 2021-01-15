package t2;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;

public class t1 {
    public static void main(String[] args) {
        t1 t1 = new t1();
        System.out.println(t1.get(6));

        int[] i = {1, 2, 3};
        int length = i.length;

        String s = "ss";
        int sLength = s.length();

    }

    int[] elementData = {1, 2, 3, 4, 5, 6};

    int size = elementData.length;

    int modCount = 0;

    private static final Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};

    private static final int DEFAULT_CAPACITY = 10;

    private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;

    private static int calculateCapacity(Object[] elementData, int minCapacity) {
        if (elementData == DEFAULTCAPACITY_EMPTY_ELEMENTDATA) {
            return Math.max(DEFAULT_CAPACITY, minCapacity);
        }
        return minCapacity;
    }

    //      判断是否需要扩容
    private void ensureExplicitCapacity(int minCapacity) {
        modCount++;

        if (minCapacity - elementData.length > 0) {
            grow(minCapacity);
        }
    }

    private void grow(int minCapacity) {
        int oldCapacity = elementData.length;
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        if (newCapacity - minCapacity < 0) {
            newCapacity = minCapacity;
        }
        if (newCapacity - MAX_ARRAY_SIZE > 0) {
            newCapacity = hugeCapacity(minCapacity);
            elementData = Arrays.copyOf(elementData, newCapacity);
        }
    }

    private static int hugeCapacity(int minCapacity) {
        if (minCapacity < 0) // overflow
            throw new OutOfMemoryError();
        return (minCapacity > MAX_ARRAY_SIZE) ?
                Integer.MAX_VALUE :
                MAX_ARRAY_SIZE;
    }

    public int get(int index) {
        return elementData(index);
    }

    //    set 用指定的元素替换此列表中所指定的元素
    public int set(int index, int ele) {
        int oldValue = elementData(index);
        elementData[index] = ele;
        return oldValue;
    }

    public boolean add(int e) {
        elementData[size++] = e;
        return true;
    }

    int elementData(int index) {
        return elementData[index];
    }

    public static int indexOf(Object o) {
        Object[] elementData = {1, 2, 3, 3, 6, 7, 8, null};

        if (o == null) {
            for (int i = 0; i < elementData.length; i++) {
                if (elementData[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = 0; i < elementData.length; i++) {
                if (o.equals(elementData[i]))
                    return i;
            }
        }
        return -1;
    }
}
