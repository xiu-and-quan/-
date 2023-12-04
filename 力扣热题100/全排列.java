package 力扣热题100;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author shizq18
 * @Date 2023/9/19
 * @Description
 */
public class 全排列 {
    List<List<Integer>> resList = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        boolean[] isvisited = new boolean[nums.length];
        track(nums,new LinkedList<Integer>(),isvisited);
        return resList;
    }

    private void track(int[] nums, LinkedList<Integer> path, boolean[] isvisited) {
        if (nums.length == path.size()) {
            resList.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (isvisited[i]) {
                continue;
            }
            // 做选择
            isvisited[i] = true;
            path.add(nums[i]);
            track(nums,path,isvisited);
            // 撤销选择
            isvisited[i] = false;
            path.removeLast();
        }
    }
}
