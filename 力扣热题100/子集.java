package 力扣热题100;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author shizq18
 * @Date 2023/9/19
 * @Description
 */
public class 子集 {
    public static void main(String[] args) {
        List<List<Integer>> res = subsets(new int[]{1, 2, 3});
        System.out.println("success");
    }

    static List<List<Integer>> resList = new ArrayList<>();
    public static List<List<Integer>> subsets(int[] nums) {
        track(nums,new LinkedList<Integer>(),0);
        return resList;
    }

    private static void track(int[] nums, LinkedList<Integer> path, int start) {
        resList.add(new ArrayList<>(path));
        for (int i = start; i < nums.length; i++) {
            // 做选择
            path.add(nums[i]);
            track(nums,path,i+1);
            // 撤销选择
            path.removeLast();
        }
    }
}
