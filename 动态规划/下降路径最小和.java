package 动态规划;

import java.util.Arrays;

public class 下降路径最小和 {
    public int minFallingPathSum(int[][] matrix) {
        int rowLength = matrix.length;
        int colLength = matrix[0].length;
        int[][] dp = new int[rowLength][colLength+2];
        for (int i = 0; i < rowLength; i++) {
            Arrays.fill(dp[i],Integer.MAX_VALUE);
        }
        for (int i = 0; i < colLength; i++) {
            dp[0][i+1] = matrix[0][i];
        }
        //遍历
        for (int i = 1; i < rowLength; i++) {
            for (int j = 0; j < colLength; j++) {
                dp[i][j+1] = calculation(dp[i-1][j],dp[i-1][j+1],dp[i-1][j+2])+matrix[i][j];
            }
        }
        int minValue=Integer.MAX_VALUE;
        for (int i = 1; i < colLength+1; i++) {
            minValue = Math.min(minValue,dp[rowLength-1][i]);
        }
        return minValue;
    }

    private int calculation(int num1, int num2, int num3) {
        int maxValue = Math.min(num1,num2);
        return Math.min(maxValue,num3);
    }
}
