package 华为od;

import java.util.Arrays;

/**
 * @Author shizq18
 * @Date 2023/6/8
 * @Description
 */
public class 放苹果 {

    /*把m个同样的苹果放在n个同样的盘子里，允许有的盘子空着不放，问共有多少种不同的分法？
    注意：如果有7个苹果和3个盘子，（5，1，1）和（1，5，1）被视为是同一种分法。*/
    public static int solve(int m, int n) {
        int[][] dp = new int[m+1][n+1];
        // base case
        for (int i = 1; i < m+1; i++) {
            dp[i][1] = 1;
        }
        for (int i = 1; i < m+1; i++) {
            for (int j = 2; j < n+1; j++) {
                // 放不放
                if(i < j) {
                    // 苹果数 < 盘子数，有空盘，
                    // 则忽略一个盘子，在n-1个放苹果，一直递推到n==1，有一种摆法
                    dp[i][j] = dp[i][j-1];
                } else {
                    // 苹果数 >= 盘子数，可以看作没有空盘
                    // 则可以选择忽略一个盘子，如上边做法
                    // 还可以选择每个盘子放一个苹果，即苹果数剩下i-j,继续递推直到j==1
                    dp[i][j] = dp[i][j-1] + dp[i-j][j];
                }
            }
        }
        return dp[m][n];
    }
}
