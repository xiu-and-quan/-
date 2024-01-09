package 力扣热题100;

import java.util.Arrays;

/**
 * @Author shizq18
 * @Date 2023/12/21
 * @Description
 */
public class 最长递增子序列 {
    public static void main(String[] args) {
        lengthOfLIS(new int[]{0,1,0,3,2,3});
    }
    public static int lengthOfLIS(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];
        Arrays.fill(dp,1);
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i],dp[j] + 1);
                }
            }
        }
        int resMax = 0;
        for (int i = 0; i < len; i++) {
            resMax = Math.max(resMax,dp[i]);
        }
        return resMax;
    }
}
