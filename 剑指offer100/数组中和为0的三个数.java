package 剑指offer100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author shizq18
 * @Date 2023/5/17
 * @Description
 */
public class 数组中和为0的三个数 {
    public static void main(String[] args) {
        threeSum(new int[]{-1,0,1,2,-1,-4});
        resList.forEach(e -> System.out.println(e));
    }
    static List<List<Integer>> resList = new ArrayList<>();
    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int j = i + 1, k = n - 1;
            while (j < k) {
                while (j > i + 1 && j < n && nums[j] == nums[j - 1]) j++;
                if (j >= k) break;
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == 0) {
                    ans.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                } else if (sum > 0) {
                    k--;
                } else if (sum < 0) {
                    j++;
                }
            }
        }
        return ans;
    }

    private static void backTrack(int[] nums, int target, List<Integer> list, boolean[] isVisited, int start) {
        // 返回条件
        if (list.size() == 3){
            int sum = 0;
            for (int i = 0; i < 3; i++) {
                sum += list.get(i);
            }
            if (sum == 0) {
                resList.add(new ArrayList<>(list));
                return;
            }
        }
        // 做选择
        for (int i = start; i < nums.length; i++) {
            if (isVisited[i]){
                continue;
            }
            isVisited[i] = true;
            list.add(nums[i]);
            // 下一次选择
            backTrack(nums, 0, list, isVisited, i+1);
            // 撤销选择
            isVisited[i] = false;
            list.remove(list.size()-1);
        }
    }
}
