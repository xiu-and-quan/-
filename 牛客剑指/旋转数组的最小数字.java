package 牛客剑指;

/**
 * @Author shizq18
 * @Date 2023/6/20
 * @Description
 */
public class 旋转数组的最小数字 {
    public int minNumberInRotateArray (int[] nums) {
        // write code here
        // 二分
        // [3,4,5,5,1,2,2]
        if (nums.length == 0) {
            return -1;
        }
        int length = nums.length;
        int left = 0, right = length-1;
        int middle = 0;
        while (left <= right) {
            middle = (left+right)/2;
            if (nums[middle] > nums[right]) {
                left = middle+1;
            }else if (nums[middle] < nums[right]){
                right = middle;
            }else {
                right = right-1;
            }
        }
        return nums[left];
    }
}
