package 牛客剑指;

import java.util.LinkedList;

/**
 * @Author shizq18
 * @Date 2023/6/20
 * @Description
 */
public class 矩阵中的路径 {
    public static void main(String[] args) {
        System.out.println(hasPath(new char[][]{{'a','b','c','e'},{'s','f','c','s'},{'a','d','e','e'}},"abcced"));
    }
    public static boolean hasPath (char[][] matrix, String word) {
        // write code here
        int rowSize = matrix.length;
        int colSize = matrix[0].length;
        int length = word.length();
        for (int i = 0; i < rowSize; i++) {
            for (int j = 0; j < colSize; j++) {
                if (matrix[i][j] == word.charAt(0)) {
                    boolean[][] isVisited = new boolean[rowSize][colSize];
                    isVisited[i][j] = true;
                    if(traver(matrix, word, i, j, isVisited,1)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private static boolean traver(char[][] matrix, String word, int i, int j, boolean[][] isVisited, int size) {
        // 结束条件
        if (size == word.length()) {
            return true;
        }
        // 路径选择 上下左右
        if (i-1>=0 && !isVisited[i-1][j] && matrix[i-1][j] == word.charAt(size)) {
            // 加入路径
            size++;
            isVisited[i-1][j] = true;
            if (traver(matrix, word, i-1, j, isVisited,size)) {
                return true;
            }
            // 恢复路径
            isVisited[i-1][j] = false;
            size--;
        }

        if (i+1<matrix.length && !isVisited[i+1][j] && matrix[i+1][j] == word.charAt(size)) {
            // 加入路径
            size++;
            isVisited[i+1][j] = true;
            if (traver(matrix, word, i+1, j, isVisited,size)) {
                return true;
            }
            isVisited[i+1][j] = false;
            // 恢复路径
            size--;
        }

        if (j-1>=0 && !isVisited[i][j-1] && matrix[i][j-1] == word.charAt(size)) {
            // 加入路径
            size++;
            isVisited[i][j-1] = true;
            if (traver(matrix, word, i, j-1, isVisited,size)) {
                return true;
            }
            // 恢复路径
            isVisited[i][j-1] = false;
            size--;
        }

        if (j+1<matrix[0].length && !isVisited[i][j+1] && matrix[i][j+1] == word.charAt(size)) {
            // 加入路径
            size++;
            isVisited[i][j+1] = true;
            if (traver(matrix, word, i, j+1, isVisited,size)) {
                return true;
            }
            // 恢复路径
            isVisited[i][j+1] = false;
            size--;
        }
        return false;
    }


}
