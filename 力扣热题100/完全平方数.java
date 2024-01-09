package 力扣热题100;

/**
 * @Author shizq18
 * @Date 2023/12/11
 * @Description
 */
public class 完全平方数 {
    public static void main(String[] args) {
        System.out.println(numSquares(13));
    }
    /*
    * 12 4+4+4
    * */
    public static int numSquares(int n) {
        int[] dp = new int[n+1];
        for (int i = 1; i <= n; i++) {
            dp[i] = i;
        }
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= (i/2); j++) {
                 if (i-j*j>=0) {
                     dp[i] = Math.min(dp[i-j*j]+1,dp[i]);
                 }
            }
        }
        return dp[n];
    }
}
