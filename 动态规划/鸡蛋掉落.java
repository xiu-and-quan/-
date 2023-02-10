package 动态规划;

import java.util.Arrays;

public class 鸡蛋掉落 {
    public int superEggDrop(int k, int n) {
        //递归解决
        //加备忘录
        int[][] dp = new int[k+1][n+1];
        for (int i = 0; i < k+1; i++) {
            Arrays.fill(dp[i],-1);
        }
        return helperFunction(k,n,dp);
    }
    //求出的最少次数 n的定义是层数
    static int helperFunction(int k ,int n,int[][] dp){
        //base case
        if (k==1){
            return n;
        }
        if (n == 0 || n== 1){
            return n;
        }
        if (dp[n][k] != -1){
            return dp[n][k];
        }
        int left =1;
        int right = n;
        int minCount = Integer.MAX_VALUE;
        while (left <= right){
            int mid = (left+right)/2;
            int isBroken = helperFunction(k-1,mid-1,dp);
            int isNotBroken = helperFunction(k,n-mid,dp);
            if (isBroken > isNotBroken){
                right = mid-1;
                minCount = Math.min(isBroken+1,minCount);
            }else {
                left = mid+1;
                minCount = Math.min(isNotBroken+1,minCount);
            }
        }
        dp[k][n] = minCount;
        return minCount;
    }
}
