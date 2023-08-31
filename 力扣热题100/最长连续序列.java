package 力扣热题100;

import java.util.Arrays;

/**
 * @Author shizq18
 * @Date 2023/7/19
 * @Description
 */
public class 最长连续序列 {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,0,1};
        System.out.println(longestConsecutive(nums));
    }
    public static int longestConsecutive(int[] nums) {
        int length = nums.length;
        if (length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        int[] dp = new int[length];
        Arrays.fill(dp,1);
        for (int i = 1; i < length; i++) {
            if (nums[i] - nums[i-1] == 1) {
                dp[i] = dp[i-1]+1;
            } else if (nums[i] == nums[i-1]) {
                dp[i] = dp[i-1];
            }
        }
        int resMax = 0;
        for (int i = 0; i < length; i++) {
            resMax = Math.max(resMax,dp[i]);
        }
        return resMax;
    }
}
