package BFS;

import java.util.LinkedList;
import java.util.Queue;

public class 岛屿数量 {
    public static void main(String[] args) {
        char[][] grid = new char[][]{{'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','0','0'},
        };
        int res = numIslands(grid);
        System.out.println(res);
    }
    //0:水 1：陆地
    public static int numIslands(char[][] grid) {
        //BFS是同时往四面八方走 采用的是队列
        //先找陆地
        int islandNum = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1'){
                    //把相连的陆地都变成水
                    BFSfunction(i,j,grid);
                    islandNum++;
                }
            }
        }
        return islandNum;
    }

    private static void BFSfunction(int i, int j, char[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{i,j});
        while (!queue.isEmpty()){
            int[] curren = queue.poll();
            int row = curren[0];
            int col = curren[1];
            if (row >= 0 && row < grid.length && col >= 0 && col < grid[0].length && grid[row][col] == '1'){
                grid[row][col] = '0';
                queue.add(new int[]{row-1,col});
                queue.add(new int[]{row+1,col});
                queue.add(new int[]{row,col-1});
                queue.add(new int[]{row,col+1});
            }
        }
    }
}
