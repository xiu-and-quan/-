package 动态规划;

import java.util.Arrays;

public class 零钱兑换 {
    public static void main(String[] args) {
        System.out.println(coinChange(new int[]{2},3));
    }
    public static int coinChange(int[] coins, int amount) {

        //base case
        int[] dp = new int[amount + 1];

        Arrays.fill(dp,amount+1);
        dp[0] = 0;
        //这一步不需要，后面已经考虑在内了
/*        for (int element:
             coins) {
            if (element == amount){
                dp[element] = 1;
            }
        }*/
        //遍历状态
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (i - coins[j] < 0){
                    continue;
                }else {
                    dp[i] = Math.min(dp[i - coins[j]] + 1,dp[i]);
                }
            }
        }
        return dp[amount] == amount+1 ? -1 : dp[amount];
    }
}
