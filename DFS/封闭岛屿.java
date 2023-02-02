package DFS;

import java.util.Arrays;

public class 封闭岛屿 {
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
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0){
                    //把相连的陆地都变成水
                    boolean isLawful = helperFunction(i,j,grid);
                    if (isLawful) {
                        islandNum++;
                        }
                    }
                }
            }
        return islandNum;
    }
    private static boolean helperFunction(int i, int j, int[][] grid) {
        //结束条件 考虑越界情况
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length){
            return false;
        }
        if (grid[i][j] == 1){
            return true;
        }
        //向四面八方前进
        grid[i][j] = 1;
//        boolean up = helperFunction(i-1,j,grid);
//        boolean down = helperFunction(i+1,j,grid);
//        boolean left = helperFunction(i,j-1,grid);
//        boolean right = helperFunction(i,j+1,grid);
//        return up && down && left && right;
        return  helperFunction(i-1,j,grid)
                & helperFunction(i+1,j,grid)
                & helperFunction(i,j-1,grid)
                & helperFunction(i,j+1,grid);
    }
}

