package 动态规划;

public class 买卖股票的最佳时机III {
    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{3,3,5,0,0,3,1,4}));
    }
    public static int maxProfit(int[] prices) {
        int size = prices.length;
        int[][][] dp = new int[size+1][3][2];
        //base case
        for (int i = 0; i < 3; i++) {
            dp[0][i][0] = 0;
            dp[0][i][1] = Integer.MIN_VALUE;
        }
        for (int i = 0; i < size; i++) {
            dp[i+1][0][0] = 0;
            dp[i+1][0][1] = Integer.MIN_VALUE;
        }
        //遍历
        for (int i = 0; i < size; i++) {
            for (int j = 1; j < 3; j++) {
                dp[i+1][j][1] = Math.max(dp[i][j-1][0]-prices[i],dp[i][j][1]);
                dp[i+1][j][0] = Math.max(dp[i][j][1]+prices[i],dp[i][j][0]);
            }
        }
        return dp[size][2][0];
    }
}
