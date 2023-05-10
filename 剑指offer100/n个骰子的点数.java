package 剑指offer100;

/**
 * @Author shizq18
 * @Date 2023/5/6
 * @Description
 */
public class n个骰子的点数 {
    public double[] dicesProbability(int n) {
        // 明确dp的定义 骰到第几个骰子点数为多少的次数
        int[][] dp = new int[n + 1][6 * n + 1];
        // base case
        for (int j = 1; j <= 6; j++) {
            dp[1][j] = 1;
        }
        // 遍历状态 转移方程
        for (int i = 2; i <= n; i++) {
            for (int j = i; j <= 6 * i; j++) {
                // 每个骰子有六种可能 每个都要考虑在内
                for (int k = 1; k <= 6; k++) {
                    if (j - k < 0){
                        break;
                    }
                    dp[i][j] += dp[i-1][j - k];
                }
            }
        }
        double[] ans = new double[5 * n + 1];
        double all = Math.pow(6, n);
        for (int i = n; i <= 6 * n; i++) {
            ans[i - n] = dp[n][i] * 1.0 / all;
        }
        return ans;
    }
}
