package 力扣热题100;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author shizq18
 * @Date 2023/8/14
 * @Description
 */
public class 螺旋矩阵 {
    public static void main(String[] args) {
        List<Integer> res = spiralOrder(new int[][]{{2,5}, {8,4},{0,-1}});
        System.out.println(0);
    }
    public static List<Integer> spiralOrder(int[][] matrix) {
        int rowLength = matrix.length;
        int colLength = matrix[0].length;
        int startRow = 0, endRow = rowLength-1,
            startCol = 0, endCol = colLength-1;
        List<Integer> resList = new ArrayList<>();
        while (startRow <= endRow && startCol <= endCol) {
            // 行
            for (int i = startCol; i <= endCol; i++) {
                resList.add(matrix[startRow][i]);
            }
            startRow++;
            // 列
            for (int i = startRow; i <= endRow; i++) {
                resList.add(matrix[i][endCol]);
            }
            endCol--;
            // 行
            if (startRow <= endRow) {
                for (int i = endCol; i >= startCol; i--) {
                    resList.add(matrix[endRow][i]);
                }
            }
            endRow--;
            // 列
            if (startCol <= endCol) {
                for (int i = endRow; i >= startRow; i--) {
                    resList.add(matrix[i][startCol]);
                }
            }
            startCol++;
        }
        return resList;
    }
}
