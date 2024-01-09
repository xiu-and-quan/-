package 力扣热题100;

import 继承相关问题.Animal;

import java.util.Arrays;

/**
 * @Author shizq18
 * @Date 2023/12/21
 * @Description
 */
public class 乘积最大子数组 {
    public static void main(String[] args) {
        System.out.println(maxProduct(new int[]{-3, -1, -1}));
    }

    /*
    * 输入: nums = [2,3,-2,4]
    输出: 6
    解释: 子数组 [2,3] 有最大乘积 6。*/
    public static int maxProduct(int[] nums) {
        int len = nums.length;
        int[] maxDp = new int[len];
        int[] minDp = new int[len];
        for (int i = 0; i < len; i++) {
            maxDp[i] = nums[i];
            minDp[i] = nums[i];
        }
        for (int i = 1; i < len; i++) {
            maxDp[i] = threeMax(maxDp[i - 1] * nums[i], nums[i], minDp[i - 1] * nums[i]);
            minDp[i] = threeMin(minDp[i - 1] * nums[i], nums[i], maxDp[i - 1] * nums[i]);
        }
        int resMax = Integer.MIN_VALUE;
        for (int i = 0; i < len; i++) {
            resMax = Math.max(resMax, maxDp[i]);
        }
        return resMax;
    }

    private static int threeMin(int i, int num, int i1) {
        return Math.min(i, Math.min(num, i1));
    }

    private static int threeMax(int i, int num, int i1) {
        return Math.max(i, Math.max(num, i1));
    }
}