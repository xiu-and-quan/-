package 力扣热题100;

/**
 * @Author shizq18
 * @Date 2023/12/8
 * @Description
 */
public class 打家劫舍 {
    public static void main(String[] args) {
        int res = rob(new int[]{1,2,3,1});
        System.out.println(res);
    }
    /*输入：[1,2,3,1]
     输出：4
     解释：偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
     偷窃到的最高金额 = 1 + 3 = 4 。*/
    public static int rob(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len+2];
        for (int i = 0; i < len; i++) {
            // 偷和不偷
            dp[i+2] = Math.max(dp[i]+nums[i],dp[i+1]);
        }
        return dp[len+1];
    }
}
