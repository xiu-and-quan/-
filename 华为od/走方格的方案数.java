package 华为od;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author shizq18
 * @Date 2023/6/13
 * @Description
 */
public class 走方格的方案数 {
    public static void main(String[] args) {
        System.out.println(solve1(2,2));
    }

    public static int solve1(int row, int col) {
        int[][] dp = new int[row+1][col+1];
        for (int i = 0; i <= row; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i <= col; i++) {
            dp[0][i] = 1;
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                dp[i+1][j+1] = dp[i][j+1] + dp[i+1][j];
            }
        }
        return dp[row][col];
    }
    public static int solve(int row, int col) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0,0});
        boolean[][] isvisited = new boolean[row][col];
        isvisited[0][0] = true;
        int resCount = 0;
        while (!queue.isEmpty()) {
            int[] element = queue.poll();
            int currentRow = element[0];
            int currentCol = element[1];
            // 上下左右
            if (currentRow-1 >= 0 && isvisited[currentRow-1][currentCol] == false) {
                resCount++;
                queue.add(new int[]{row-1,col});
                isvisited[currentRow-1][currentCol] = true;
            }
            if (currentRow+1 < row && isvisited[currentRow+1][currentCol] == false) {
                resCount++;
                queue.add(new int[]{currentRow+1,currentCol});
                isvisited[currentRow+1][currentCol] = true;
            }
            if (currentCol-1 >=0 && isvisited[currentRow][currentCol-1] == false) {
                resCount++;
                queue.add(new int[]{currentRow,currentCol-1});
                isvisited[currentRow][currentCol-1] = true;
            }
            if (currentCol+1 < col && isvisited[currentRow][currentCol+1] == false) {
                resCount++;
                queue.add(new int[]{currentRow,currentCol+1});
                isvisited[currentRow][currentCol+1] = true;
            }
        }
        return resCount;
    }
}
