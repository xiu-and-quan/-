package 动态规划;

public class 最长回文子序列 {
    public static void main(String[] args) {
        System.out.println(longestPalindromeSubseq("bbbab"));
    }
    /*输入：s = "bbbab"
    输出：4
    解释：一个可能的最长回文子序列为 "bbbb" 。*/
    public static int longestPalindromeSubseq(String s) {
        //斜着遍历 求得是长度
        int size = s.length();
        int[][] dp = new int[size][size];
        //base case
        for (int i = 0; i < size; i++) {
            dp[i][i] = 1;
        }
        for (int length = 1; length < size; length++) {
            for (int left = 0; left < size; left++) {
                int right = left + length;
                //考虑越界问题
                if (right >= size){
                    continue;
                }else {
                    if (s.charAt(left) == s.charAt(right)){
                        dp[left][right] = dp[left+1][right-1]+2;
                    }else {
                        dp[left][right] = Math.max(dp[left][right-1],dp[left+1][right]);
                    }
                }
            }
        }
        return dp[0][size-1];
    }
}
