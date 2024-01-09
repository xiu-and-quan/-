package 力扣热题100;

import java.util.Arrays;

/**
 * @Author shizq18
 * @Date 2024/1/8
 * @Description
 */
public class 编辑距离 {
    public static void main(String[] args) {
        System.out.println(minDistance("", "a"));
    }
    public static int minDistance(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        int[][] dp = new int[len2+1][len1+1];
        for (int i = 0; i <= len1; i++) {
            dp[0][i] = i;
        }
        for (int i = 0; i <= len2; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i < len2; i++) {
            for (int j = 0; j < len1; j++) {
                if (word2.charAt(i) == word1.charAt(j)) {
                    dp[i+1][j+1] = dp[i][j];
                }else {
                    // 插入，删除，替换
                    dp[i+1][j+1] = min(dp[i][j+1], dp[i][j], dp[i+1][j])+1;
                }
            }
        }
        return dp[len2][len1];
    }

    private static int min(int num1, int num2, int num3) {
        return Math.min(num1, Math.min(num2, num3));
    }
}
