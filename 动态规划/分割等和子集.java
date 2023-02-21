package 动态规划;



public class 分割等和子集 {
    public static void main(String[] args) {
        System.out.println(canPartition(new int[]{2,2,1,1}));
    }
    /*给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。*/
    //输入：nums = [1,5,11,5]
    //输出：true
    //解释：数组可以分割成 [1, 5, 5] 和 [11] 。
    public static boolean canPartition(int[] nums) {
        int size = nums.length;
        int sum = 0;
        for (int i = 0; i < size; i++) {
            sum += nums[i];
        }
        if (sum % 2 != 0){
            return false;
        }
        int acerage = sum / 2;
        boolean[][] dp = new boolean[acerage+1][nums.length+1];
        for (int i = 0; i <= size; i++) {
            dp[0][i] = true;
        }
        for (int i = 1; i <= acerage; i++) {
            for (int j = 0; j < size; j++) {
                if (i - nums[j] < 0){
                    dp[i][j+1] = dp[i][j];
                }else {
                    //可以选择用或者不用的
                    dp[i][j+1] = dp[i-nums[j]][j] || dp[i][j];
                }
            }
        }
        return dp[acerage][size];
    }
}
