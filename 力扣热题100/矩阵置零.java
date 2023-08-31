package 力扣热题100;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author shizq18
 * @Date 2023/8/14
 * @Description
 */
public class 矩阵置零 {
    public static void main(String[] args) {
        setZeroes(new int[][]{{0,1,2,0},{3,4,5,2},{1,3,1,5}});
    }
    public static void setZeroes(int[][] matrix) {
        int rowLength = matrix.length;
        int colLength = matrix[0].length;
        int[] rowList = new int[rowLength];
        int[] colList = new int[colLength];
        for (int i = 0; i < rowLength; i++) {
            for (int j = 0; j < colLength; j++) {
                if (matrix[i][j] == 0) {
                    rowList[i] = 1;
                    colList[j] = 1;
                }
            }
        }
        for (int i = 0; i < rowLength; i++) {
            if (rowList[i] == 1) {
                for (int j = 0; j < colLength; j++) {
                    matrix[i][j] = 0;
                }
            }
        }

        for (int i = 0; i < colLength; i++) {
            if (colList[i] == 1) {
                for (int j = 0; j < rowLength; j++) {
                    matrix[j][i] = 0;
                }
            }
        }
    }
}
