package 剑指offer100;

public class 青蛙跳台 {
    public static void main(String[] args) {
        System.out.println(numWays(7));
    }
    public static int numWays(int n) {
        if(n == 0){
            return 1;
        }
        int[] dp = new int[n+1];
        dp[0]=1;
        dp[1]=1;
        for(int i = 2; i <= n ;i++){
            dp[i] = (dp[i-1]+dp[i-2])%1000000007;
        }
        return dp[n];
    }
}
