package 回溯算法DFS算法;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


/**
 * 全排列问题 和 N皇后问题
 */

/**
 * @author fangsheng
 * @date 2021/3/24 下午2:46
 */
public class T1 {

    public static void main(String[] args) {
        T1 t1 = new T1();
        List<List<Integer>> permute = t1.permute(new int[]{1, 2, 3});
        for (List<Integer> integers : permute) {
            System.out.println(integers);
        }
    }

    List<List<Integer>> res = new LinkedList<>();

    List<List<Integer>> permute(int[] nums) {
        LinkedList<Integer> track = new LinkedList<>();
        backtrack(nums, track);
        return res;
    }

    /***
     *  // 路径：记录在 track 中
     *  // 选择列表：nums 中不存在于 track 的那些元素
     *  // 结束条件：nums 中的元素全都在 track 中出现
     * @param nums
     * @param track
     */
    void backtrack(int[] nums, LinkedList<Integer> track) {
        // 触发结束条件
        if (track.size() == nums.length) {
            res.add(new LinkedList<>(track));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            // 排除不合法的选择
            if (track.contains(nums[i])) {
                continue;
            }
            // 做选择
            track.add(nums[i]);
            // 进入下一层决策树
            backtrack(nums, track);
            // 取消选择
            track.removeLast();
        }
    }
}
