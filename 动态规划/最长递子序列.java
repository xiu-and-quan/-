package 动态规划;

import java.util.Arrays;

public class 最长递子序列 {
    public static void main(String[] args) {
        System.out.println(lengthOfLIS(new int[]{4,10,4,3,8,9}));
    }
//    输入：nums = [10,9,2,5,3,7,101,18]
//    输出：4
//    解释：最长递增子序列是 [2,3,7,101]，因此长度为 4
    public static int lengthOfLIS(int[] nums) {
        //base case 是1
        //确定dp[i]的定义为:前面有几个比它大的数字
        int[] dp = new int[nums.length];
        Arrays.fill(dp,1);
        //遍历状态 做选择
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        int maxValue = 0;
        for (int i = 0; i < dp.length; i++) {
            maxValue = Math.max(maxValue,dp[i]);
        }
        return maxValue;
    }
}
