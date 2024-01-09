package 力扣热题100;

import java.util.Arrays;

/**
 * @Author shizq18
 * @Date 2023/12/26
 * @Description
 */
public class 分割等和子集 {
    public static void main(String[] args) {
        System.out.println(solve(new int[]{1,2,5}));
    }
    public static boolean canPartition(int[] nums) {
        int len = nums.length;
        int sum = 0;
        for (int i = 0; i < len; i++) {
            sum += nums[i];
        }
        if (sum % 2 != 0) {
            return false;
        }
        int average = sum / 2;
        return help(nums,0,0,average);
    }

    public static boolean help(int[] nums, int start, int currentSum, int average) {
        if (currentSum == average) {
            return true;
        }
        for (int i = start; i < nums.length; i++) {
            if (currentSum + nums[i] > average) {
                continue;
            }
            // 选择
            currentSum += nums[i];
            // 进行下一次选择
            if(help(nums,i+1,currentSum,average)){
                return true;
            }
            // 撤销选择
            currentSum -= nums[i];
        }
        return false;
    }

    public static boolean solve(int[] nums){
        int len = nums.length;
        int sum = 0;
        for (int i = 0; i < len; i++) {
            sum += nums[i];
        }
        if (sum % 2 != 0) {
            return false;
        }
        int average = sum / 2;
        boolean[][] dp = new boolean[average+1][len+1];
        Arrays.fill(dp[0],true);
        for (int i = 1; i <= average; i++) {
            for (int j = 0; j < len; j++) {
                if (i-nums[j]>=0) {
                    dp[i][j+1] = dp[i-nums[j]][j] || dp[i][j];
                } else {
                    dp[i][j+1] = dp[i][j];
                }
            }
        }
        return dp[average][len];
    }
}
