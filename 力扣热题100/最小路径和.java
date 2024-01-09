package 力扣热题100;

/**
 * @Author shizq18
 * @Date 2024/1/4
 * @Description
 */
public class 最小路径和 {
    public static void main(String[] args) {
        System.out.println(minPathSum(new int[][]{{1,3,1},{1,5,1},{4,2,1}}));
    }
    public static int minPathSum(int[][] grid) {
        int rowSize = grid.length;
        int colSize = grid[0].length;
        int[][] dp = new int[rowSize][colSize];
        dp[0][0] = grid[0][0];
        for (int i = 1; i < rowSize; i++) {
            dp[i][0] = dp[i-1][0] + grid[i][0];
        }
        for (int i = 1; i < colSize; i++) {
            dp[0][i] = dp[0][i-1] + grid[0][i];
        }
        for (int i = 1; i < rowSize; i++) {
            for (int j = 1; j < colSize; j++) {
                dp[i][j] = Math.min(dp[i][j-1],dp[i-1][j]) + grid[i][j];
            }
        }
        return dp[rowSize-1][colSize-1];
    }
}
