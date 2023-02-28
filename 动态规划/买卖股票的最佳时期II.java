package 动态规划;

public class 买卖股票的最佳时期II {
    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7,1,5,3,6,4}));;
    }
    public static int maxProfit(int[] prices) {
        int size = prices.length;
        int[][] dp = new int[size+1][2];
        //base case
        //无限制交易次数
        dp[0][0] = 0;
        //还没开始不可能持有股票
        dp[0][1] = Integer.MIN_VALUE;
        //遍历
        for (int i = 0; i < size; i++) {
            dp[i+1][1] = Math.max(dp[i][0]-prices[i],dp[i][1]);
            dp[i+1][0] = Math.max(dp[i][1]+prices[i],dp[i][0]);
        }
        return dp[size][0];
    }
}
