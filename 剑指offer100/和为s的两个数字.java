package 剑指offer100;

/**
 * @author shizq18
 * @since 2023/4/28
 */
public class 和为s的两个数字 {
    public static void main(String[] args) {
        System.out.println(twoSum(new int[]{2,7,11,15}, 9));
    }

    public static int[] twoSum(int[] nums, int target) {
        int length = nums.length;
        int left = 0, right = length-1;
        while (left <= right){
            if (nums[left] + nums[right] == target){
                break;
            }
            if (nums[left] + nums[right] < target){
                left++;
            }
            if (nums[left] + nums[right] > target){
                right--;
            }
        }
        return new int[]{nums[left], nums[right]};
    }
}
