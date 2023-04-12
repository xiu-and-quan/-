package 剑指offer100;

import java.util.HashMap;

public class 数组中出现次数超过一半的数字 {
    public static void main(String[] args) {
        System.out.println(majorityElement(new int[]{1,2,3,2,2,2,5,4,2}));
    }
    public static int majorityElement(int[] nums) {
        HashMap<Integer,Integer> numsToCount = new HashMap<>();
        int size = nums.length;
        int halfSize = size/2;
        int resNum = 0;
        for (int i = 0; i < size; i++) {
            int count = numsToCount.getOrDefault(nums[i],0);
            numsToCount.put(nums[i],++count);
            if (count > halfSize){
                resNum = nums[i];
                break;
            }
        }
        return resNum;
    }
}
