package 字符串;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * @author fangsheng
 * @date 2021/5/24 11:17 上午
 */
public class T1 {
    public static void main(String[] args) {
        String[] strings = {"flower", "flow", "flight"};
        Arrays.sort(strings);
        System.out.println(Arrays.asList(strings));
    }

    @Test
    public void t1() {
        String str1 = new String("SEU") + new String("Calvin");
        System.out.println(str1.intern() == str1);
        System.out.println(str1 == "SEUCalvin");
    }

    @Test
    public void t2() {
        String str1 = "SEUCalvin";
        String str2 = new String("SEU") + new String("Calvin");
        System.out.println(str2.intern() == str2);
        System.out.println(str2 == "SEUCalvin");
    }

    static final int MAX = 100000;
    static final String[] arr = new String[MAX];

    @Test
    public void t3() {
        //为长度为10的Integer数组随机赋值
        Integer[] sample = new Integer[10];
        Random random = new Random(1000);
        for (int i = 0; i < sample.length; i++) {
            sample[i] = random.nextInt();
        }
        //记录程序开始时间
        long t = System.currentTimeMillis();
        //使用/不使用intern方法为10万个String赋值，值来自于Integer数组的10个数
        for (int i = 0; i < MAX; i++) {
//            arr[i] = new String(String.valueOf(sample[i % sample.length]));
            arr[i] = new String(String.valueOf(sample[i % sample.length])).intern();
        }
        System.out.println((System.currentTimeMillis() - t) + "ms");
        System.gc();

    }
}
