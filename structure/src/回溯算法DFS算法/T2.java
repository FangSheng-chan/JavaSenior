package 回溯算法DFS算法;

/**
 * 求子集
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author fangsheng
 * @date 2021/4/2 上午9:48
 */
public class T2 {
    public static void main(String[] args) {
        T2 t2 = new T2();
        int[] nums = {1, 2, 3};
        System.out.println(t2.permute(nums));
    }

    List<List<Integer>> res = new ArrayList<>();

    /***
     * 子集
     * @param nums
     * @return
     */
    List<List<Integer>> subsets(int[] nums) {
        List<Integer> track = new ArrayList<>();
        backtrack(nums, 0, track);
        return res;
    }

    /**
     * 组合
     *
     * @param n
     * @param k
     * @return
     */
    List<List<Integer>> combine(int n, int k) {
        if (k <= 0 || n <= 0) {
            return res;
        }
        List<Integer> track = new ArrayList<>();
        backtrack2(n, k, 1, track);
        return res;
    }

    List<List<Integer>> permute(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();
        backtrack3(nums, list);
        return res;
    }

    /**
     * 子集
     *
     * @param nums
     * @return
     */
    void backtrack(int[] nums, int start, List<Integer> track) {
        res.add(new LinkedList<>(track));
        for (int i = start; i < nums.length; i++) {
            track.add(nums[i]);
            backtrack(nums, i + 1, track);
            track.remove(track.size() - 1);
        }
    }

    /**
     * 组合
     *
     * @param n
     * @param k
     * @return
     */
    void backtrack2(int n, int k, int start, List<Integer> track) {
        //到达数的底部
        if (k == track.size()) {
            res.add(new ArrayList<>(track));
            return;
        }
        for (int i = start; i <= n; i++) {
            track.add(i);
            backtrack2(n, k, i + 1, track);
            track.remove(track.size() - 1);
        }
    }

    /**
     * 排列
     *
     * @param nums
     * @param track
     */
    void backtrack3(int[] nums, List<Integer> track) {
        if (track.size() == nums.length) {
            res.add(new ArrayList<>(track));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (track.contains(nums[i])) {
                continue;
            }
            track.add(nums[i]);
            backtrack3(nums, track);
            track.remove(track.size() - 1);
        }
    }
}
