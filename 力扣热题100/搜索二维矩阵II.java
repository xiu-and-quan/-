package 力扣热题100;

/**
 * @Author shizq18
 * @Date 2023/8/17
 * @Description
 */
public class 搜索二维矩阵II {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
        searchMatrix(matrix, 5);
    }
    public static boolean searchMatrix(int[][] matrix, int target) {
        int rowLength = matrix.length,
            colLength = matrix[0].length;
        int startRow = rowLength-1,
            startCol = 0;
        while (startRow >= 0 && startCol < colLength) {
            if (matrix[startRow][startCol] < target) {
                startCol++;
            } else if (matrix[startRow][startCol] > target) {
                startRow--;
            } else {
                return true;
            }
        }
        return false;
    }
}
