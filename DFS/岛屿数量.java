package DFS;

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
        //先找陆地
        int islandNum = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1'){
                    //把相连的陆地都变成水
                    helperFunction(i,j,grid);
                    islandNum++;
                }
            }
        }
        return islandNum;
    }

    private static void helperFunction(int i, int j, char[][] grid) {
        //结束条件 考虑越界情况
        if (i < 0 || i == grid.length || j < 0 || j == grid[0].length){
            return;
        }
        if (grid[i][j] == '0'){
            return;
        }
        //向四面八方前进
        grid[i][j] = '0';
        helperFunction(i-1,j,grid);
        helperFunction(i+1,j,grid);
        helperFunction(i,j-1,grid);
        helperFunction(i,j+1,grid);
    }
}
