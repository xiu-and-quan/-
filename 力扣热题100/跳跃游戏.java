package 力扣热题100;

/**
 * @Author shizq18
 * @Date 2023/12/4
 * @Description
 */
public class 跳跃游戏 {
    public boolean solve(int[] nums) {
        int len = nums.length;
        boolean[] dp = new boolean[len];
        dp[0] = true;
        for (int i = 0; i < len; i++) {
            for (int j = 1; j <= nums[i]; j++) {
                if (i+j >= len-1) {
                    dp[len-1] = true;
                } else {
                    dp[i + j] = dp[i];
                }
            }
        }
        return dp[len-1];
    }
}
