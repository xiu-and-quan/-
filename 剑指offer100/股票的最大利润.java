package 剑指offer100;

/**
 * @Author shizq18
 * @Date 2023/5/8
 * @Description
 */
public class 股票的最大利润 {
    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7,1,5,3,6,4}));
    }
    public static int maxProfit(int[] prices) {
        int length = prices.length;
        // 动态规划 dp[][][] 第几天 交易次数 手里有没有股票
        int[][][] dp = new int[length+1][2][2];
        // base case
        // 不可能出现001的情况的
        dp[0][1][1] = Integer.MIN_VALUE;
        // 遍历状态
        // 第几天
        for (int i = 0; i < length; i++) {
            // 交易次数
            for (int j = 1; j < 2; j++) {
                // 手里有股票 两种可能 前一天就有 前一天没有，今天买了 交易次数减1
                dp[i+1][j][1] = Math.max(dp[i][j][1], dp[i][j-1][0]-prices[i]);
                // 手里没有股票 两种可能 前一天就没有 前一天有，今天卖了了
                dp[i+1][j][0] = Math.max(dp[i][j][0], dp[i][j][1] + prices[i]);
            }
        }
        // 最后肯定手里没有股票才会赚
        return dp[length][1][0];
    }
}
