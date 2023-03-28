package 剑指offer100;

import java.util.HashSet;

public class 数组中重复的数字 {
    public int findRepeatNumber(int[] nums) {
        HashSet<Integer> isExist= new HashSet<>();
        for(int i = 0;i<nums.length;i++){
            if(isExist.add(nums[i]) == false){
                return nums[i];
            }
        }
        return -1;
    }
}
