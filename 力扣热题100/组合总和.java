package 力扣热题100;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author shizq18
 * @Date 2023/9/28
 * @Description
 */
public class 组合总和 {
    List<List<Integer>> resList = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // 回溯
        List<Integer> path = new ArrayList<>();
        traver(candidates, target, path, 0);
        return resList;
    }

    private void traver(int[] candidates, int target, List<Integer> path, int start) {
        if (target == 0) {
            resList.add(new ArrayList<>(path));
            return;
        }
        if (target < 0){
            return;
        }
        // 做选择
        for (int i = start; i < candidates.length; i++) {
            // 添加路径
            path.add(candidates[i]);
            // 下一次选择 可以重复选择，继续当前的start
            traver(candidates,target-candidates[i],path,i);
            // 撤销路径
            path.remove(path.size()-1);
        }
    }
}
