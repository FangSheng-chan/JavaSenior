package 回溯算法DFS算法;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author fangsheng
 * @date 2021/3/24 下午2:46
 */
public class T1 {

    List<List<Integer>> res = new LinkedList<>();

//    public List<List<Integer>> permute(int[] nums) {
//
//    }

    void backtrack(int[] nums, LinkedList<Integer> track) {
        if (track.size() == nums.length) {
            res.add(new LinkedList<>(track));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (track.contains(nums[i])) {
                continue;
            }
            track.add(nums[i]);
            backtrack(nums, track);
            track.removeLast();
        }
    }
}
