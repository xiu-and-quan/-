package 动态规划;

public class 打家劫舍IV {
    public static void main(String[] args) {
        System.out.println(minCapability(new int[]{2,3,5,9},2));
    }
    public static int minCapability(int[] nums, int k) {
        int size = nums.length;
        int[][] dp = new int[size+1][k+1];
        //base case

        //遍历
        for (int i = 0; i < size; i++) {
            for (int j = 1; j <= k; j++) {
                dp[i+1][k] = Math.max(dp[i][k-1]+nums[i],dp[i][k]);
            }
        }
        return dp[size][k];
    }
}
