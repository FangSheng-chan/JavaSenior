package 位运算符;

import org.junit.Test;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;

/**
 * @author fangsheng
 * @date 2021/4/12 上午11:06
 */
public class T1 {
    @Test
    public void test() {

    }

    /**
     * 与运算(&)：都为1时才为1
     * <p>
     * （1）清零 ：只要任何数和 0 进行 与运算
     */
    @Test
    public void test1() {
        int a = 129;
        int b = 128;
        int c = 0;
        System.out.println(a & b);
        System.out.println(a & c);
    }

    /**
     * 或运算符(|)：有一个1，则为1
     * <p>
     * 方法：找到一个数，对应X要置1的位，该数的对应位为1，其余位为零。此数与X相或可使X中的某些位置1。
     * 例：将X=10100000的低4位置1 ，用 X | 0000 1111 = 1010 1111即可得到。
     */
    @Test
    public void test2() {
        int a = 7;
        int b = 9;
        System.out.println(a | b);
    }

    /**
     * 异或运算(^)：不同为1
     * <p>
     * （1）使特定位翻转找一个数，对应X要翻转的各位，该数的对应位为1，其余位为零，此数与X对应位异或即可。
     * 例：X=10101110，使X低4位翻转，用X ^ 0000 1111 = 1010 0001即可得到。
     * <p>
     * （2）与0相异或，保留原值 ，X ^ 0000 0000 = 1010 1110。
     * （3）一个数和它本身做异或运算结果为0，一个数和0做异或运算还是它本身
     * （4）异或运算满足交换律和结合律，也就是说：2 ^ 3 ^ 2 = 3 ^ (2 ^ 2) = 3 ^ 0 = 3
     */
    @Test
    public void test3() {
        int a = 7;
        int b = 9;
        System.out.println(a ^ b);
    }

    @Test
    public void test4() {
        long a = 128;
        int b = 129;
        System.out.println(a & b);
    }

    @Test
    public void test5() {
        int a = 7;
        System.out.println(~a);
    }

    @Test
    public void test6() {
        System.out.println('A' | ' ');
        System.out.println('a' | ' ');
        System.out.println("-----");
        System.out.println('b' | '_');
    }

    /**
     * 判断是否为异号
     */
    @Test
    public void test7() {
        int x = -1, y = 2;
        System.out.println((x ^ y));
        System.out.println(((x ^ y) < 0));
    }

    @Test
    public void test8() {
        int x = 3, y = 2;
        System.out.println((x ^ y) < 0);
    }

    @Test
    public void test10() {
        int x = 3, y = 2;
        System.out.println(x & (x - 1));
    }

    /**
     * 找有几个1
     * <p>
     * n&(n-1) 可以消除最后一个1
     *
     * @param n
     * @return
     */
    static int hammingWeight(int n) {
        int res = 0;
        while (n != 0) {
            n = n & (n - 1);
            res++;
        }
        return res;
    }

    /**
     * 判断n是不是2的指数
     *
     * @param n
     * @return
     */
    static boolean isPowerIfTwo(int n) {
        if (n <= 0) {
            return false;
        }
        return (n & (n - 1)) == 0;
    }

    @Test
    public void test9() {
        System.out.println(hammingWeight(7));
        System.out.println(isPowerIfTwo(7));
        System.out.println(singleNumber(new long[]{4, 1, 2, 2, 3, 4, 3, 1, 5}));
    }

    @Test
    public void test11() {
        System.out.println(factorial(0));
        System.out.println(trailingZero(55));
        System.out.println(trailingZeroes(125));
        System.out.println(1 / 5);
    }

    @Test
    public void test12() {
        System.out.println(countPrimes(12));
    }

    public static BigInteger factorial(int n) {
        if (n == 0) {
            return BigInteger.ONE;
        }
        return new BigInteger(String.valueOf(n)).multiply(factorial(n - 1));
    }


    public static BigDecimal f(int num) {
        BigDecimal sum = new BigDecimal("1");
        if (num < 0) {
            throw new IllegalArgumentException("参数不能为负!");
        }
        for (int i = 1; i <= num; i++) {
            //循环进行累乘
            sum = sum.multiply(new BigDecimal(i));
        }
        // 返回结果字符串
        return sum;
    }

    public int trailingZero(int n) {
        BigInteger bigInteger = BigInteger.ONE;
        for (int i = 2; i <= n; i++) {
            bigInteger = bigInteger.multiply(BigInteger.valueOf(i));
        }
        int zeroCount = 0;
        while (bigInteger.mod(BigInteger.TEN).equals(BigInteger.ZERO)) {
            bigInteger = bigInteger.divide(BigInteger.TEN);
            zeroCount++;
        }
        return zeroCount;
    }

    /**
     * 一个数和他本身做异或运算为0 即 a ^ a = 0
     * 一个数和0做异或运算为它本身 即 a ^ 0 = a
     *
     * @param nums
     * @return
     */
    static long singleNumber(long[] nums) {
        long res = 0;
        for (long num : nums) {
            res ^= num;
        }
        return res;
    }

    static int trailingZeroes(int n) {
        int res = 0;
        for (int d = n; d / 5 > 0; d = d / 5) {
            res += d / 5;
        }
        return res;
    }

    int countPrimes(int n) {
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime(i)) {
                count++;
            }
        }
        return count;
    }

    boolean isPrime(int n) {
        for (int i = 2; i * i < n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    @Test
    public void t13() {
        System.out.println(findDisappearedNumbers(new int[]{1, 2, 3, 4, 5, 8, 9, 7}));
        int[] errorNums = findErrorNums2(new int[]{1, 2, 2, 4});
        for (int errorNum : errorNums) {
            System.out.print(errorNum + "\t");
        }
    }


    List<Integer> findDisappearedNumbers(int[] nums) {
        HashSet<Integer> hashSet = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            hashSet.add(num);
        }
        for (int i = 1; i <= nums.length; i++) {
            if (!hashSet.contains(i)) {
                list.add(i);
            }
        }
        return list;
    }

    public int[] findErrorNums(int[] nums) {
        Map<Integer, Integer> hashMap = new HashMap<>();
        int dup = -1, miss = -1;
        for (int num : nums) {
            hashMap.put(num, hashMap.getOrDefault(num, 0) + 1);
        }
        for (int i = 1; i <= nums.length; i++) {
            if (hashMap.containsKey(i)) {
                if (hashMap.get(i) == 2) {
                    dup = i;
                }
            } else {
                miss = i;
            }
        }
        return new int[]{dup, miss};
    }

    public int[] findErrorNums2(int[] nums) {
        int dup = -1, miss = -1;
        for (int i = 1; i < nums.length; i++) {
            int count = 0;
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] == i) {
                    count++;
                }
            }
            if (count == 2) {
                dup = i;
            } else if (count == 0) {
                miss = i;
            }
        }
        return new int[]{dup, miss};
    }

    @Test
    public void t14() {
        int i = removeDuplicates(new int[]{1, 3, 3, 3, 4, 5, 5, 6});
        System.out.println(i);
    }

    int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int slow = 0, fast = 0;
        while (fast < nums.length) {
            if (nums[fast] != nums[slow]) {
                slow++;
                nums[slow] = nums[fast];
            }
            fast++;
        }
        return slow + 1;
    }

    int removeElement(int[] nums, int val) {
        int fast = 0, slow = 0;
        while (fast < nums.length) {
            if (nums[fast] != val) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        return slow;
    }

    @Test
    public void test15() {
        int i = removeElement(new int[]{1, 3, 3, 3, 4, 5, 5, 6},3);
        System.out.println(i);
    }
}


















