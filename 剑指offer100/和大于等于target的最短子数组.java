package 剑指offer100;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author shizq18
 * @Date 2023/5/18
 * @Description
 */
public class 和大于等于target的最短子数组 {
    public static void main(String[] args) {
        System.out.println(minSubArrayLen1(7, new int[]{2,3,1,2,4,3}));
    }

    public static int minSubArrayLen1(int target, int[] nums) {

        // 双指针
        int length = nums.length;
        int sum = 0;
        int ans = length + 1;
        int left = 0, right = 0;
        while (right <= length - 1) {
            sum += nums[right];
            while (sum >= target){
                ans = Math.min(ans, right-left+1);
                sum -= nums[left];
                left++;
            }
                right++;
        }
        return ans == length + 1 ? 0 : ans;
    }

    public static int minSubArrayLen(int target, int[] nums) {

        int length = nums.length;
        int[] sumBefore = new int[length];
        int res = 0;
        for (int i = 0; i < length; i++) {
            res += nums[i];
            sumBefore[i] = res;
        }
        // 斜着遍历 按照数组长度来
        // 第一层是长度
        for (int i = 1; i <= length; i++) {
            // 第二层是开始位置
            for (int j = 0; j <= length-1; j++) {
                int right = j + i - 1;
                // 考虑右边界越界问题
                if (right < length){
                    if (j == 0){
                        if (sumBefore[right] >= target){
                            return i;
                        }
                    }else {
                        if (sumBefore[right] - sumBefore[j-1] >= target){
                            return i;
                        }
                    }
                }
            }
        }
        return 0;
    }
}
