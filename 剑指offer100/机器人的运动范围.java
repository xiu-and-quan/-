package 剑指offer100;

import java.util.*;

/**
 * @Author shizq18
 * @Date 2023/6/9
 * @Description
 */
public class 机器人的运动范围 {
    static int rowMax = 0;
    static int colMax = 0;

    public static void main(String[] args) {
        System.out.println(movingCount(38,15,9));
        System.out.println("effective_or_ineffective".toUpperCase());
    }

    public static int movingCount(int m, int n, int k) {
        rowMax = m;
        colMax = n;
        // BFS
        int resCount = 1;
        Queue<int[]> queue= new LinkedList<>();
        // 防止回头路
        boolean[][] visited = new boolean[m][n];
        visited[0][0] = true;
        queue.add(new int[]{0,0});
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] currentElement = queue.poll();
                int row = currentElement[0];
                int col = currentElement[1];
                // 上下左右
                if (isvailted(row-1,col,k) && visited[row-1][col] == false) {
                    resCount++;
                    queue.add(new int[]{row-1,col});
                    visited[row-1][col] = true;
                }
                if (isvailted(row+1,col,k) && visited[row+1][col] == false) {
                    resCount++;
                    queue.add(new int[]{row+1,col});
                    visited[row+1][col] = true;
                }
                if (isvailted(row,col-1,k) && visited[row][col-1] == false) {
                    resCount++;
                    queue.add(new int[]{row,col-1});
                    visited[row][col-1] = true;
                }
                if (isvailted(row,col+1,k) && visited[row][col+1] == false) {
                    resCount++;
                    queue.add(new int[]{row,col+1});
                    visited[row][col+1] = true;
                }

            }
        }
        return resCount;
    }

    private static boolean isvailted(int row, int col, int k) {
        if (row < 0 || row >= rowMax || col < 0 || col >= colMax) {
            return false;
        }
        int leftSum = 0;
        int rightSum = 0;
        if (row < 10) {
            leftSum = row;
        }else {
            leftSum = row / 10 + row % 10;
        }

        if (col < 10) {
            rightSum = col;
        }else {
            rightSum = col / 10 + col % 10;
        }

        if (leftSum + rightSum > k) {
            return false;
        }
        return true;
    }
}
