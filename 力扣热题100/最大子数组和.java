package 力扣热题100;

/**
 * @Author shizq18
 * @Date 2023/8/2
 * @Description
 */
public class 最大子数组和 {
    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
    }
    public static int maxSubArray(int[] nums) {
        int length = nums.length , res = Integer.MIN_VALUE;
        int[] dp = new int[length];
        dp[0] = nums[0];
        for (int i = 1; i < length; i++) {
            if (dp[i-1]+nums[i] > nums[i]) {
                dp[i] = dp[i-1]+nums[i];
            }else {
                dp[i] = nums[i];
            }
        }

        for (int i = 0; i < length; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
