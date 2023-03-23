package 动态规划;

public class 打家劫舍 {
    public int rob(int[] nums) {
        int size = nums.length;
        int[] dp = new int[size+2];
        for (int i = 0; i < size; i++) {
            dp[i+2] = Math.max(nums[i]+dp[i],dp[i+1]);
        }
        return dp[size+1];
    }
}
