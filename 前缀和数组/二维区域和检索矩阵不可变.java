package 前缀和数组;

import java.util.Arrays;

public class 二维区域和检索矩阵不可变 {
    /*给定一个二维矩阵 matrix，以下类型的多个请求：
    计算其子矩形范围内元素的总和，该子矩阵的 左上角 为 (row1, col1) ，右下角 为 (row2, col2) 。
    实现 NumMatrix 类：
    NumMatrix(int[][] matrix) 给定整数矩阵 matrix 进行初始化
    int sumRegion(int row1, int col1, int row2, int col2) 返回 左上角 (row1, col1) 、右下角 (row2, col2) 所描述的子矩阵的元素 总和 。
*/
    public static void main(String[] args) {
        int[][] nums = new int[][]{{0,1,2},{3,4,5},{6,7,8}};
        NumMatrix matrix = new NumMatrix(nums);
        /*for (int[] item:
             matrix.sums) {
            System.out.println(Arrays.toString(item));;
        }*/
        int res =matrix.sumRegion(1,1,2,2);
        System.out.println(res);
    }
}
class NumMatrix {
    int[][] sums;
    public NumMatrix(int[][] matrix) {
        sums = new int[matrix.length+1][matrix[0].length+1];
        int res = 0;
        for (int i = 0; i < matrix.length; i++) {
            int temp = 0;
            for (int j = 0; j < matrix[0].length; j++) {
                if (i == 0){
                    res += matrix[i][j];
                    sums[i+1][j+1]= res;
                }else {
                    temp += matrix[i][j];
                    sums[i+1][j+1] = sums[i][j+1] + temp;
                }
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return sums[row2+1][col2+1] - sums[row1][col2+1] - sums[row2+1][col1] + sums[row1][col1];
    }
}