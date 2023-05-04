package 剑指offer100;

public class 连续子数组的最大和 {
    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[]{1}));
    }
    public static int maxSubArray(int[] nums) {
        //base case
        int[] dp = nums;
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i],dp[i-1]+nums[i]);
        }
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < dp.length; i++) {
            res = Math.max(res,dp[i]);
        }
        return res;
    }
}
