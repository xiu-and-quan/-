package 剑指offer100;

/**
 * @Author shizq18
 * @Date 2023/5/23
 * @Description
 */
public class 左右两边子数组的和相等 {
    public static void main(String[] args) {
        System.out.println(pivotIndex(new int[]{1,2,3}));
    }
    public static int pivotIndex(int[] nums) {
        // 双指针无法解决负数问题
        int totalSum = 0;
        int length = nums.length;
        int preSum = 0;
        for (int i = 0; i < length; i++) {
            totalSum += nums[i];
        }
        // 前缀和等于后缀和
        int resIndex = -1;
        for (int i = 0; i < length; i++) {
            preSum += nums[i];
            if (preSum == totalSum - preSum + nums[i]) {
                resIndex = i;
                break;
            }
        }
        return resIndex;
    }
}
