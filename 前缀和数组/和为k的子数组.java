package 前缀和数组;

import java.util.Arrays;
import java.util.HashMap;

public class 和为k的子数组 {
    /*给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的连续子数组的个数 。
    输入：nums = [1,1,1], k = 2
    输出：2
    示例 2：

    输入：nums = [1,2,3], k = 3
    输出：2*/
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3};
        System.out.println(subarraySum(nums,3));
    }
    //优化
    //之所以不能先用hash存起来，是因为有负数，导致后面的值影响前面的值
    public static int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer>  map = new HashMap<>();
        map.put(0,1);
        int res = 0, num_i = 0, num_j = 0;
        for (int i = 0; i < nums.length; i++) {
            num_i += nums[i];
            num_j = num_i - k;
            if (map.containsKey(num_j)){
                res += map.get(num_j);
            }
            map.put(num_i,map.getOrDefault(num_i,0)+1);
        }
        return res;
    }

    //传统
    public static int subarraySum1(int[] nums, int k) {
        int[] sums = new int[nums.length + 1];
        int currSum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i == 0){
                sums[i+1]= nums[i];
            }else {
                sums[i+1] = sums[i] + nums[i];
            }
        }
        //System.out.println(Arrays.toString(sums));
        int res = 0;
        for (int right = 1; right <= nums.length; right++) {
            for (int left = 0; left < right; left++) {

                //System.out.println("left ="+left +"!!!"+ "right=" + right + "和为" +sum);
                if (sums[right] - sums[left] == k){
                    res++;
                }
            }
        }
        return res;
    }
}
