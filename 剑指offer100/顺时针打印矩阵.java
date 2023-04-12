package 剑指offer100;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 顺时针打印矩阵 {
    public static void main(String[] args) {
        spiralOrder(new int[][]{
                {7},
                {9},
                {6}});

    }
    public static int[] spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new int[0];
        }
        int rows = matrix.length, cols = matrix[0].length;
        int[] res = new int[rows * cols];
        int index = 0;
        int left = 0, right = cols - 1, top = 0, bottom = rows - 1;
        while (left <= right && top <= bottom) {
            for (int i = left; i <= right; i++) {
                res[index++] = matrix[top][i];
            }
            for (int i = top + 1; i <= bottom; i++) {
                res[index++] = matrix[i][right];
            }
            if (left < right && top < bottom) {
                for (int i = right - 1; i >= left; i--) {
                    res[index++] = matrix[bottom][i];
                }
                for (int i = bottom - 1; i > top; i--) {
                    res[index++] = matrix[i][left];
                }
            }
            left++;
            right--;
            top++;
            bottom--;
        }
        return res;
    }
}
