package 剑指offer100;

import java.util.Arrays;

public class 调整数组顺序使奇数位于偶数前面 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(exchange(new int[]{1,2,3,4})));
    }
    public static int[] exchange(int[] nums) {
        //双指针
        int numsLength = nums.length;
        int left = 0, right = numsLength-1;
        while (left <= right){
            if (nums[left] % 2 == 0){
                //对调位置
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                right--;
            }else {
                left++;
            }
        }
        return nums;
    }
}
