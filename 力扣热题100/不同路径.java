package 力扣热题100;

/**
 * @Author shizq18
 * @Date 2024/1/4
 * @Description
 */
public class 不同路径 {
    public static void main(String[] args) {
        String start = "2024-01-06";
        String end = "2024-01-05";
        if (start.compareTo(end) >= 0) {
            System.out.println("大于");
        }
//        System.out.println(uniquePaths(3,2));
    }
    public static int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i][j-1] + dp[i-1][j];
            }
        }
        return dp[m-1][n-1];
    }
}
