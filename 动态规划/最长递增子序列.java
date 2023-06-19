package 动态规划;

import java.util.Arrays;
import java.util.Map;

/**
 * @Author shizq18
 * @Date 2023/6/13
 * @Description
 */
public class 最长递增子序列 {
    public static void main(String[] args) {

    }

    public static int solve(int[] array) {
        int length = array.length;
        int[] dp = new int[length];
        Arrays.fill(dp,1);
        for (int i = 1; i < length; i++) {
            for (int j = 0; j < i; j++) {
                if (array[i] > array[j]) {
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
        }
        int res = 0;
        for (int i = 0; i < length; i++) {
            res = Math.max(res,dp[i]);
        }
        return res;
    }
}
