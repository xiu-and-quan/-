package 华为od;

import java.util.Arrays;
import java.util.Map;

/**
 * @Author shizq18
 * @Date 2023/5/31
 * @Description
 */
public class 最长递增子序列 {
    public static void main(String[] args) {
        solve(new int[]{7,7,7,7,7,7,7});
    }
    public static void solve(int[] array) {
        int length = array.length;
        // 前i个最长递增子序列
        int[] dp = new int[length];
        Arrays.fill(dp,1);
        for (int i = 1; i < length; i++) {
            for (int j = 0; j < i; j++) {
                if (array[i] > array[j]) {
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
        }
        System.out.println(Arrays.toString(dp));
    }
}
