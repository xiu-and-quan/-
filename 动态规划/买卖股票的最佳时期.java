package 动态规划;

public class 买卖股票的最佳时期 {
    public static int maxProfit(int[] prices) {
        int size = prices.length;
        int[][][] dp = new int[size+1][2][2];
        //base case
        dp[0][0][0] = 0;
        //还没开始不可能持有股票
        dp[0][1][1] = Integer.MIN_VALUE;
        //遍历
        for (int i = 0; i < size; i++) {
            for (int j = 1; j < 2; j++) {
                dp[i+1][j][1] = Math.max(dp[i][j-1][0]-prices[i],dp[i][j][1]);
                dp[i+1][j][0] = Math.max(dp[i][j][1]+prices[i],dp[i][j][0]);
            }
        }
        return dp[size][1][0];
    }
}
