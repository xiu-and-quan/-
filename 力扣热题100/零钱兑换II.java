package 力扣热题100;

import java.util.Arrays;
import java.util.Map;

/**
 * @Author shizq18
 * @Date 2023/12/12
 * @Description
 */
public class 零钱兑换II {
    public static int change(int amount, int[] coins) {
        int len = coins.length;
        int[][] dp = new int[amount+1][len+1];
        for (int i = 0; i <= len; i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i <= amount; i++) {
                for (int k = 0; k < len; k++) {
                    if (i-coins[k] >= 0) {
                        dp[i][k+1] = dp[i-coins[k]][k+1] + dp[i][k];
                    } else {
                        dp[i][k+1] = dp[i][k];
                    }
                }
        }
        return dp[amount][len];
    }

    public static void main(String[] args) {
        System.out.println(changeI(11,new int[]{1,2,5}));
    }
    public static int changeI(int amount, int[] coins) {
        int[] dp = new int[amount+1];
        Arrays.fill(dp,amount+1);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (i-coins[j] >= 0) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]]+1);
                }
            }
        }
        return dp[amount] == amount+1 ? -1:dp[amount];
    }
}
