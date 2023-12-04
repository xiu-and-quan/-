package 力扣热题100;

/**
 * @Author shizq18
 * @Date 2023/10/18
 * @Description
 */
public class 在排序数组中找第一个和最后一个元素 {
    /**
     * 给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。请你找出给定目标值在数组中的开始位置和结束位置。
     *
     * 如果数组中不存在目标值 target，返回 [-1, -1]。
     *
     * 你必须设计并实现时间复杂度为 O(log n) 的算法解决此问题。
     *
     *
     *
     * 示例 1：
     *
     * 输入：nums = [5,7,7,8,8,10], target = 8
     * 输出：[3,4]
     * 示例 2：
     *
     * 输入：nums = [5,7,7,8,8,10], target = 6
     * 输出：[-1,-1]
     * 示例 3：
     *
     * 输入：nums = [], target = 0
     * 输出：[-1,-1]
     */
    public static void main(String[] args) {
        int[] res = searchRange(new int[]{1}, 0);
        System.out.println("success");
    }
    public static int[] searchRange(int[] nums, int target) {
        // 左边界和右边界
        if (nums.length == 0) {
            return new int[]{-1,-1};
        }
        int left = findLeft(nums, target);
        int right = findRight(nums, target);
        return new int[]{left, right};
    }

    private static int findRight(int[] nums, int target) {
        int len = nums.length;
        int left = 0;
        int right = len-1;
        while (left <= right) {
            int middle = (left+right)/2;
            if (nums[middle] == target) {
                left = middle+1;
            } else if (nums[middle] < target) {
                left = middle+1;
            } else {
                right = middle-1;
            }
        }
        return right < len && right >= 0 && nums[right] == target ? right : -1;
    }

    private static int findLeft(int[] nums, int target) {
        int len = nums.length;
        int left = 0;
        int right = len-1;
        while (left <= right) {
            int middle = (left+right)/2;
            if (nums[middle] == target) {
                right = middle-1;
            } else if (nums[middle] < target) {
                left = middle+1;
            } else {
                right = middle-1;
            }
        }
        return left >= 0 && left < left && nums[left] == target ? left : -1;
    }
}
