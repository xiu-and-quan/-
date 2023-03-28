package 剑指offer100;

import java.util.LinkedList;
import java.util.Queue;

public class 二维数组中的查找 {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1,2,3},{2,3,4},{3,4,5}};
        System.out.println(findNumberIn2DArray(matrix,5));
    }
    public static boolean findNumberIn2DArray(int[][] matrix, int target){
        if(matrix.length == 0){
            return false;
        }
        if(matrix[0].length == 0){
            return false;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        //bfs
        Queue<int[]> queue = new LinkedList<>();
        //IsPuted
        boolean[][] isPuted = new boolean[row][col];
        queue.add(new int[]{0,0});
        isPuted[0][0] = true;
        while (!queue.isEmpty()){
            //队列中的元素个数，决定弹出的次数
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();
                int currentRow = curr[0];
                int currentCol = curr[1];
                if (matrix[currentRow][currentCol] == target){
                    return true;
                }
                if (matrix[currentRow][currentCol] > target){
                    continue;
                }
                //four direction
                //is out of bound

                //up
                if (currentRow - 1 >=0  && isPuted[currentRow-1][currentCol] == false){
                    queue.add(new int[]{currentRow-1,currentCol});
                    isPuted[currentRow-1][currentCol] = true;
                }
                //down
                if (currentRow + 1 < row && isPuted[currentRow+1][currentCol] == false){
                    queue.add(new int[]{currentRow+1,currentCol});
                    isPuted[currentRow+1][currentCol] = true;
                }

                //left
                if (currentCol - 1 >= 0 && isPuted[currentRow][currentCol-1] == false){
                    queue.add(new int[]{currentRow,currentCol-1});
                    isPuted[currentRow][currentCol-1] = true;
                }
                //right
                if (currentCol + 1 < col && isPuted[currentRow][currentCol+1] == false){
                    queue.add(new int[]{currentRow,currentCol+1});
                    isPuted[currentRow][currentCol+1] = true;
                }
            }
        }
        return false;
    }
}
