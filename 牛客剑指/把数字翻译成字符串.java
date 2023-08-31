package 牛客剑指;

import java.util.Arrays;

/**
 * @Author shizq18
 * @Date 2023/7/14
 * @Description
 */
public class 把数字翻译成字符串 {
    public static void main(String[] args) {
        
    }
    int translateNum(int num) {
        String nums = String.valueOf(num);
        // write code here
        int[] dp = new int[nums.length()+1];
        dp[0]=1;
        dp[1]=1;
        for (int i = 1; i < nums.length(); i++) {
            String temp = nums.substring(i - 1, i + 1);
            if ("25".compareTo(temp) >= 0 && "10".compareTo(temp) <= 0) {
                dp[i + 1] = dp[i] + dp[i - 1];
            } else {
                dp[i + 1] = dp[i - 1];
            }
        }
        return dp[nums.length()];
    }
}
