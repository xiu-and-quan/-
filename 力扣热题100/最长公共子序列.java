package 力扣热题100;

/**
 * @Author shizq18
 * @Date 2024/1/8
 * @Description
 */
public class 最长公共子序列 {
    public int longestCommonSubsequence(String text1, String text2) {
        int len1 = text1.length();
        int len2 = text2.length();
        // text1和text2的索引位置的公共最长子序列
        int[][] dp = new int[len1+1][len2+1];
        for (int i = 0; i < len1; i++) {
            for (int j = 0; j < len2; j++) {
                // 相等的情况
                if (text1.charAt(i) == text2.charAt(j)) {
                    dp[i+1][j+1] = dp[i][j] + 1;
                } else {
                    dp[i+1][j+1] = Math.max(dp[i][j+1],dp[i+1][j]);
                }
            }
        }
        return dp[len1][len2];
    }
}
