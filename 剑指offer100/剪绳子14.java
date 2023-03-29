package 剑指offer100;

public class 剪绳子14 {
    public static void main(String[] args) {
        System.out.println(cuttingRope(120));
    }
    public static int cuttingRope(int n) {
        if (n == 2){
            return 1;
        }
        if (n == 3){
            return 2;
        }
        //动态规划
        int[] dp = new int[n+1];
        //base case
        for (int i = 0; i <= n; i++) {
            dp[i] = i;
        }
        //遍历状态做选择
        for(int i = 3;i <= n;i++){
            for(int j = 1; j < i;j++){
                dp[i] = Math.max(dp[i],dp[i-j]*j)%1000000007;
            }
        }
        return dp[n];
    }
}
