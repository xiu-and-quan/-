package 剑指offer100;

public class 丑数 {
    public static void main(String[] args) {
        System.out.println(nthUglyNumber(11));
    }

    /**
     *  计算第n个丑数
     */
    public static int nthUglyNumber(int n) {
        //定义为第i个丑数是dp[i]
        int[] dp = new int[n];
        dp[0] = 1;
        //三个指针
        int pointA = 0, pointB = 0, pointC = 0;
        for (int i = 1; i <= n; i++) {
            //计算最小值
            dp[i] = caculateMinValue(dp[pointA] * 2, dp[pointB] * 3, dp[pointC] * 5);
            if (dp[i] == dp[pointA] * 2){
                pointA++;
            }
            if (dp[i] == dp[pointB] * 3) {
                pointB++;
            }
            if (dp[i] == dp[pointC] * 5) {
                pointC++;
            }
        }
        return dp[n-1];
    }

    /**
     *  计算三个数的最小值
     */
    private static int caculateMinValue(int num1, int num2, int num3) {
        return Math.min(Math.min(num1, num2), num3);
    }
}
