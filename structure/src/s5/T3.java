package s5;

/**
 * @author fangsheng
 * @date 2021/3/24 上午10:37
 */
public class T3 {
    public static void main(String[] args) {
        int max = getMax(new int[]{1, 1, 1, 2, 3, 4, 5});
        System.out.println(max);
    }

    /**
     * 暴力解法
     *
     * @param students
     * @return
     */
    static int getMax(int[] students) {
        int result = 0;
        for (int i : students) {
            for (int j : students) {
                if (i == j) {
                    continue;
                }
                result = Math.max(result, i - j);
            }
        }
        return result;
    }


}
