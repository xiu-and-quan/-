package 剑指offer100;

public class 礼物的最大价值 {
    public int maxValue(int[][] grid) {
        int rowSize = grid.length;
        int colSize = grid[0].length;
        int[][] dp = new int[rowSize+1][colSize+1];
        for (int i = 0; i < rowSize; i++) {
            for (int j = 0; j < colSize; j++) {
                dp[i+1][j+1] = Math.max(dp[i+1][j],dp[i][j+1])+grid[i][j];
            }
        }
        return dp[rowSize][colSize];
    }
}
