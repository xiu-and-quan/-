package 力扣热题100;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author shizq18
 * @Date 2023/9/14
 * @Description
 */
public class 岛屿数量 {
    public int numIslands(char[][] grid) {
        // bfs与dfs
        int rowSize = grid.length;
        int colSize = grid[0].length;
        int islandCount = 0;
        for (int i = 0; i < rowSize; i++) {
            for (int j = 0; j < colSize; j++) {
                if (grid[i][j] == '1') {
//                    dfs(grid,i,j);
                    bfs(grid,i,j);
                    islandCount++;
                }
            }
        }
        return islandCount;
    }

    private void bfs(char[][] grid, int i, int j) {
        int rowSize = grid.length;
        int colSize = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{i,j});
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int row = current[0];
            int col = current[1];
            grid[row][col] = '0';
            // 上下左右
            if (row-1 >= 0 && row < rowSize && col >= 0 && col < colSize && grid[row-1][col] == '1') {
                queue.add(new int[]{row-1,col});
            }
            if (row >= 0 && row+1 < rowSize && col >= 0 && col < colSize && grid[row+1][col] == '1') {
                queue.add(new int[]{row+1,col});
            }
            if (row >= 0 && row < rowSize && col-1 >= 0 && col-1 < col && grid[row][col-1] == '1') {
                queue.add(new int[]{row,col-1});
            }
            if (row >= 0 && row < rowSize && col >= 0 && col+1 < col && grid[row][col+1] == '1') {
                queue.add(new int[]{row,col+1});
            }
        }
    }

    private void dfs(char[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) {
            return;
        }
        if (grid[i][j] == '0') {
            return;
        }
        // 返回条件
        if (grid[i][j] == '1') {
            grid[i][j] = '0';
        }
        //上下左右
        dfs(grid,i-1,j);
        dfs(grid,i+1,j);
        dfs(grid,i,j-1);
        dfs(grid,i,j+1);
    }
}
