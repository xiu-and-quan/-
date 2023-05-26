package 剑指offer100;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author shizq18
 * @Date 2023/5/23
 * @Description
 */
public class 和为k的子数组 {
    public static void main(String[] args) {
        System.out.println(subarraySum(new int[]{1,1,1}, 2));
    }
    public static int subarraySum(int[] nums, int k) {
        // 前缀和和哈希表
        // pre[j] - pre[i] = k; 就是求前缀和为k的子数组的个数
        int length = nums.length;
        Map<Integer, Integer> sumToCount = new HashMap<>();
        int sum = 0, res = 0;
        sumToCount.put(0, 1);
        for (int i = 0; i < length; i++) {
            sum += nums[i];
            if (sumToCount.containsKey(sum - k)) {
                res += sumToCount.get(sum-k);
            }else {
                sumToCount.put(sum, sumToCount.getOrDefault(sum,0)+1);
            }
        }
        return res;
    }
}
