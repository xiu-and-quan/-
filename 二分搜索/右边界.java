package 二分搜索;

public class 右边界 {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,2,3,3};
        System.out.println(right(nums,3));
    }
    public static int right(int[] nums, int target){
        int left = 0, right = nums.length - 1, middle = 0;
        while (left <= right){
            middle = (left + right)/2;
            if (nums[middle] == target){
                left = middle + 1;
            }
            if (nums[middle] < target){
                left = middle + 1;
            }
            if (nums[middle] > target){
                right = middle - 1;
            }
        }
        if (right == -1 || nums[right] != target){
            return -1;
        }
        return right;
    }
}
