package 高频面试系列;

import java.math.BigDecimal;
import java.util.HashMap;

/**
 * @author fangsheng
 * @date 2021/4/26 9:37 上午
 */
public class T1 {
    public static void main(String[] args) {
        String multiply = multiply("123412312", "56");
        BigDecimal bigDecimal = new BigDecimal("123412312");
        BigDecimal bigDecimal1 = new BigDecimal("56");
        BigDecimal multiply1 = bigDecimal.multiply(bigDecimal1);
        String s = multiply1.toString();
        System.out.println(s);
        System.out.println(multiply);
    }

    static String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        int m = num1.length(), n = num2.length();
        int[] ansArr = new int[m + n];
        for (int i = m - 1; i >= 0; i--) {
            int x = num1.charAt(i) - '0';
            for (int j = n - 1; j >= 0; j--) {
                int y = num2.charAt(j) - '0';
                ansArr[i + j + 1] += x * y;
            }
        }
        for (int i = m + n - 1; i > 0; i--) {
            ansArr[i - 1] += ansArr[i] / 10;
            ansArr[i] %= 10;
        }
        int index = ansArr[0] == 0 ? 1 : 0;
        StringBuffer ans = new StringBuffer();
        while (index < m + n) {
            ans.append(ansArr[index]);
            index++;
        }
        return ans.toString();
    }
}

