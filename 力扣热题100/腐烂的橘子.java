package 力扣热题100;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author shizq18
 * @Date 2023/9/15
 * @Description
 */
public class 腐烂的橘子 {
    public static void main(String[] args) {
        int res = orangesRotting(new int[][]{{2,2},{1,1},{0,0},{2,0}});
//        int res = orangesRotting(new int[][]{{0,2,2}});
        System.out.println(res);
    }
    public static int orangesRotting(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        int rowSize = grid.length;
        int colSize = grid[0].length;
        int resMinutes = 0;
        int twoCount = 0;
        int niceOrige = 0;
        for (int i = 0; i < rowSize; i++) {
            for (int j = 0; j < colSize; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new int[]{i, j});
                } else if (grid[i][j] == 1) {
                    niceOrige++;
                }

            }
        }
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int k = 0; k < size; k++) {
                int[] current = queue.poll();
                int row = current[0];
                int col = current[1];
                // 要把感染的橘子放进去
                // 添加上下左右
                if (row - 1 >= 0 && row - 1 < rowSize && col >= 0 && col < colSize && grid[row - 1][col] == 1) {
                    grid[row-1][col] = 2;
                    niceOrige--;
                    queue.add(new int[]{row - 1, col});
                }
                if (row + 1 >= 0 && row + 1 < rowSize && col >= 0 && col < colSize && grid[row + 1][col] == 1) {
                    grid[row+1][col] = 2;
                    niceOrige--;
                    queue.add(new int[]{row + 1, col});
                }
                if (row >= 0 && row < rowSize && col - 1 >= 0 && col - 1 < colSize && grid[row][col - 1] == 1) {
                    grid[row][col-1] = 2;
                    niceOrige--;
                    queue.add(new int[]{row, col - 1});
                }
                if (row >= 0 && row < rowSize && col + 1 >= 0 && col + 1 < colSize && grid[row][col + 1] == 1) {
                    grid[row][col+1] = 2;
                    niceOrige--;
                    queue.add(new int[]{row, col + 1});
                }
            }
            resMinutes++;
        }

        if (niceOrige > 0) {
            return -1;
        }
        return resMinutes == 0? 0 : resMinutes-1;
    }
}
