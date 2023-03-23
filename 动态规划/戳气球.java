package 动态规划;

public class 戳气球 {
    public int maxCoins(int[] nums) {
        int size = nums.length;
        //区间dp[][]
        int[][] dp = new int[size+2][size+2];
        //base case
        int[] poins = new int[size+2];
        poins[0] = poins[size+1] = 1;
        for (int i = 0; i < size; i++) {
            poins[i+1] = nums[i];
        }
        //遍历状态做选择
        //网格图
        for (int i = size; i >= 0; i--) {
            for (int j = i+1; j < size+2; j++) {
                for (int k = i+1; k < j; k++) {
                    dp[i][j] = Math.max(dp[i][j],dp[i][k]+nums[i]*nums[k]*nums[j]+dp[k][j]);
                }
            }
        }
        return dp[0][size+1];
    }
}
