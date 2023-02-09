package 动态规划;

import java.util.Arrays;

public class 零钱兑换II {
    public static void main(String[] args) {
        System.out.println(change(5,new int[]{1,2,5}));
    }
    public static int change(int amount, int[] coins) {
        //base case
        int[][] dp = new int[coins.length+1][amount + 1];
        for (int i = 1; i <= coins.length; i++) {
            dp[i][0]=1;
        }
        //遍历状态
        for (int i = 0; i < coins.length; i++) {
            for (int j = 1; j <= amount; j++) {
                if (j - coins[i] < 0){
                    dp[i+1][j] = dp[i][j];
                }else {
                    dp[i+1][j] = dp[i+1][j-coins[i]] + dp[i][j];
                }
            }
        }
        return dp[coins.length][amount];
    }
}
