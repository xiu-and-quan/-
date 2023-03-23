package 动态规划;

public class 打家劫舍II {
    public static void main(String[] args) {
        rob(new int[]{1});
    }
    public static int rob(int[] nums) {
        int size = nums.length;
        if (size == 1){
            return nums[0];
        }
        int[] dp1 = new int[size+2];
        int[] dp2 = new int[size+2];
        for (int i = 0; i < size-1; i++) {
            dp1[i+2] = Math.max(nums[i]+dp1[i],dp1[i+1]);
        }
        for (int i = 1; i < size; i++) {
            dp2[i+2] = Math.max(nums[i]+dp2[i],dp2[i+1]);
        }
        return Math.max(dp1[size],dp2[size+1]);
    }

}
