package DFS;

public class 岛屿的最大面积 {
    public int maxAreaOfIsland(int[][] grid) {
            int maxAreaSize = 0;
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (grid[i][j] == 1) {
                        //把相连的陆地都变成水
                        maxAreaSize = Math.max(maxAreaSize, helperFunction(i, j, grid));
                    }
                }
            }
            return maxAreaSize;
        }

        private static int helperFunction ( int i, int j, int[][] grid){
            //结束条件 考虑越界情况
            if (i < 0 || i == grid.length || j < 0 || j == grid[0].length) {
                return 0;
            }
            if (grid[i][j] == 0) {
                return 0;
            }
            //向四面八方前进
            grid[i][j] = 0;
            return
                    helperFunction(i - 1, j, grid)
                            + helperFunction(i + 1, j, grid)
                            + helperFunction(i, j - 1, grid)
                            + helperFunction(i, j + 1, grid)
                            + 1;
        }
}
