package BFS;

import java.util.LinkedList;
import java.util.Queue;

public class 封闭岛屿 {
    //封闭岛屿就是把非封闭岛屿的边缘全部去掉
    public static void main(String[] args) {
        /*int[][] grid = new int[][]{{1,1,1,1,1,1,1,0},
                {1,0,0,0,0,1,1,0},
                {1,0,1,0,1,1,1,0},
                {1,0,0,0,0,1,0,1},
                {1,1,1,1,1,1,1,0}
        };*/
        int[][] grid = new int[][]{ {0,0,1,1,0,1,0,0,1,0},
                                    {1,1,0,1,1,0,1,1,1,0},
                                    {1,0,1,1,1,0,0,1,1,0},
                                    {0,1,1,0,0,0,0,1,0,1},
                                    {0,0,0,0,0,0,1,1,1,0},
                                    {0,1,0,1,0,1,0,1,1,1},
                                    {1,0,1,0,1,1,0,0,0,1},
                                    {1,1,1,1,1,1,0,0,0,0},
                                    {1,1,1,0,0,1,0,1,0,1},
                                    {1,1,1,0,1,1,0,1,1,0}
        };
        int res = closedIsland(grid);
        System.out.println(res);}
    public static int closedIsland(int[][] grid) {
        //先找陆地
        int islandNum = 0;
        int rowLength = grid.length;
        int colLength = grid[0].length;
        for (int i = 0; i < rowLength; i++) {
            if (grid[i][0] == 0){
                BFSfunction(i,0,grid);
            }
            if (grid[i][colLength-1] == 0){
                BFSfunction(i,colLength-1,grid);
            }
        }
        for (int i = 0; i < colLength; i++) {
            if (grid[0][i] == 0){
                BFSfunction(0,i,grid);
            }
            if (grid[rowLength-1][i] == 0){
                BFSfunction(rowLength-1,i,grid);
            }
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0){
                    //把相连的陆地都变成水
                    BFSfunction(i,j,grid);
                    islandNum++;
                    }
                }
            }
        return islandNum;
    }

    private static void BFSfunction(int i, int j, int[][] grid) {
        //队列 图的遍历
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{i,j});
        while (!queue.isEmpty()){
            int[] currentElement = queue.poll();
            int row = currentElement[0];
            int col = currentElement[1];
            if (row >= 0 && row < grid.length && col >= 0 && col < grid[0].length && grid[row][col] == 0){
                grid[row][col] = 1;
                queue.add(new int[]{row-1,col});
                queue.add(new int[]{row+1,col});
                queue.add(new int[]{row,col-1});
                queue.add(new int[]{row,col+1});
            }
        }
    }
}

