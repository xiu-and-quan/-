package 力扣热题100;

/**
 * @Author shizq18
 * @Date 2024/1/4
 * @Description
 */
public class 最长回文子串 {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("ccc"));
    }
    public static String longestPalindrome(String s) {
        char[] chars = s.toCharArray();
        int len = chars.length;
        // 区间范围内是否是回文串
        boolean[][] dp = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j <= i; j++) {
                dp[i][j] = true;
            }
        }
        // 斜着遍历
        for (int i = len-2; i >= 0; i--) {
            for (int j = i+1; j < len; j++) {
                if (chars[i] == chars[j]) {
                    dp[i][j] = dp[i+1][j-1];
                }
            }
        }
        int max = 1;
        int start = 0;
        int end = 0;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (dp[i][j]) {
                    if (j-i+1 > max) {
                        start = i;
                        end = j;
                        max = j-i+1;
                    }
                }
            }
        }
        return s.substring(start, end+1);
    }
}
