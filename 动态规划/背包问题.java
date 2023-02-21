package 动态规划;

public class 背包问题 {
    public static void main(String[] args) {
        System.out.println(knapsack(4,3,new int[]{2,1,3},new int[]{4,2,3}));
    }
    /*给你⼀个可装载重量为 W 的背包和 N 个物品，每个物品有重量和价值两个属性。其中第 i 个物品的重量为
    wt[i]，价值为 val[i]，现在让你⽤这个背包装物品，最多能装的价值是多少？*/
    public static int knapsack(int W, int N, int[] wt, int[] val){
        //dp的定义 重量为W,使用前n个物品
        int[][] dp = new int[W+1][N+1];
        //遍历装填
        for (int i = 1; i <= W; i++) {
            for (int j = 0; j < N; j++) {
                if (i - wt[j] < 0){
                    dp[i][j+1] = dp[i][j];
                }else {
                    dp[i][j+1] = Math.max(dp[i-wt[j]][j]+val[j],dp[i][j]);
                }
            }
        }
        return dp[W][N];
    }
}
