package 力扣热题100;

import 华为od.走方格的方案数;

/**
 * @Author shizq18
 * @Date 2024/1/3
 * @Description
 */
public class 最长有效括号 {
    public int longestValidParentheses(String s) {
        int len = s.length();
        int[] dp = new int[len+1];
        for (int i = 1; i < len; i++) {
            if (s.charAt(i) == ')' && i-1 >= 0 && s.charAt(i-1) == '(') {
                dp[i+1] = dp[i-1] + 1;
            }
        }
        int resMax = 0;
        for (int i = 0; i <= len; i++) {
            resMax = Math.max(resMax,dp[i]);
        }
        return 2*resMax;
    }
}
