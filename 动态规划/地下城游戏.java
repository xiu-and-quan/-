package 动态规划;

public class 地下城游戏 {
    public static void main(String[] args) {
        System.out.println(calculateMinimumHP(new int[][]{
                {0,0,0},
                {1,1,-1}
        }));
    }
    public static int calculateMinimumHP(int[][] dungeon) {
        //只能向右或者向下
        //目标是求骑士的初始健康值
        int rowLength = dungeon.length;
        int colLength = dungeon[0].length;
        int[][] dp =new int[rowLength+1][colLength+1];
        //base case
        for (int i = 0; i <= rowLength; i++) {
            dp[i][colLength] = Integer.MAX_VALUE;
        }
        for (int i = 0; i <= colLength; i++) {
            dp[rowLength][i] = Integer.MAX_VALUE;
        }
        if (dungeon[rowLength-1][colLength-1] >= 0){
            dp[rowLength-1][colLength-1] = 1;
        }else {
            dp[rowLength - 1][colLength - 1] = -dungeon[rowLength - 1][colLength - 1] + 1;
        }
        for (int i = rowLength-1; i >= 0; i--) {
            for (int j = colLength -1; j >= 0; j--) {
                if (i == rowLength-1 && j == colLength-1){
                    continue;
                }
                dp[i][j] = Math.min(dp[i + 1][j], dp[i][j + 1]) - dungeon[i][j];
                if (dp[i][j] <= 0){
                    dp[i][j] = 1;
                }

            }
        }
        return dp[0][0];
    }
}
