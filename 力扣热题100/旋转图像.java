package 力扣热题100;

/**
 * @Author shizq18
 * @Date 2023/8/15
 * @Description
 */
public class 旋转图像 {
    public void rotate(int[][] matrix) {
        int rowLength = matrix.length;
        int colLength = matrix[0].length;
        int[][] tempMatris = matrix;
        for (int i = 0; i < rowLength; i++) {
            for (int j = 0; j < colLength; j++) {
                matrix[j][colLength-i] = tempMatris[i][j];
            }
        }
    }
}

