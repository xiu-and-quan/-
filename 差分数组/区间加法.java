package 差分数组;

import java.util.Arrays;

public class 区间加法 {
    /*对一个数组的索引i到j进行操作，返回结果
    * 输入的是三元数组 多次操作*/
    public static void main(String[] args) {
        Solution solution = new Solution(new int[5]);
        int[] res = solution.increment(new int[][]{{1,3,2},{2,4,3},{0,2,-2}});
        System.out.println(Arrays.toString(res));
    }
}
class Solution {
    private int[] diff;
    private int[] res;

    /*输入一个初始数组，区间操作在这个数组上进行*/
    public Solution(int[] nums) {
        int len = nums.length;
        diff = new int[len];
        res = new int[len];
        diff[0] = nums[0];
        for (int i = 1; i < len; i++) {
            diff[i] = nums[i] - nums[i - 1];
        }
    }

    public int[] increment(int[][] xiaoDingDuidates) {

        for (int i = 0; i < xiaoDingDuidates.length; i++) {
            diff[xiaoDingDuidates[i][0]] += xiaoDingDuidates[i][2];
            if (xiaoDingDuidates[i][1] + 1 < diff.length) {
                diff[xiaoDingDuidates[i][1] + 1] -= xiaoDingDuidates[i][2];
            }
        }
        res[0] = diff[0];
        for (int k = 1; k < diff.length; k++) {
            res[k] = res[k - 1] + diff[k];
        }
        System.out.println(Arrays.toString(res));
        return res;
    }
}
