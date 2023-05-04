package 剑指offer100;

/**
 * @author shizq18
 * @since 2023/4/28
 */
public class 在排序数组中查找数字I {
    public static void main(String[] args) {
        int resIndex = search(new int[]{5,7,7,8,8,10},8);
        System.out.println(resIndex);
    }
    /**
     * 统计一个数字在排序数组中出现的次数
     */
    public static int search(int[] nums, int target) {
        // 二分查找法
        boolean isExist = findtarget(nums, target);
        if (isExist) {
            int start = findLeftBound(nums, target);
            int end = findRightBound(nums, target);
            return end - start + 1;
        }else {
            return 0;
        }
    }

    /**
     * 找到target右边界
     */
    private static int findRightBound(int[] nums, int target) {
        int length = nums.length;
        int left = 0;
        int right = length - 1;
        int middle = 0;
        while (left <= right){
            middle = (left + right) / 2;
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
        return nums[left-1] == target ? left-1 : 0;
    }

    /**
     * 找到target左边界
     */
    private static int findLeftBound(int[] nums, int target) {
        int length = nums.length;
        int left = 0;
        int right = length - 1;
        int middle = 0;
        while (left <= right){
            middle = (left + right) / 2;
            if (nums[middle] == target){
                right = middle-1;
            }
            if (nums[middle] < target){
                left = middle + 1;
            }
            if (nums[middle] > target){
                right = middle - 1;
            }
        }
        return nums[left] == target ? left : 0;
    }

    /**
     * 找到target
     */
    private static boolean findtarget(int[] nums, int target) {
        int length = nums.length;
        int left = 0;
        int right = length - 1;
        int middle = 0;
        while (left <= right){
            middle = (left + right) / 2;
            if (nums[middle] == target){
                return true;
            }
            if (nums[middle] < target){
                left = middle + 1;
            }
            if (nums[middle] > target){
                right = middle - 1;
            }
        }
        return false;
    }
}
