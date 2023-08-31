package 牛客剑指;

/**
 * @Author shizq18
 * @Date 2023/8/4
 * @Description
 */
public class 缺失的第一个正数 {
    public static void main(String[] args) {
        int res = firstMissingPositive(new int[]{1, 1});
        System.out.println(res);
    }
    public static int firstMissingPositive(int[] nums) {
        // 原地哈希 把数组作为哈希表 一个萝卜一个坑
        int length = nums.length;
        int res = 0;
        for (int i = 0; i < length; i++) {
            while (nums[i] > 0 && nums[i] <= length && nums[nums[i] - 1] != nums[i]) {
                swap(nums, i, nums[i]-1);
            }
        }
        for (int i = 0; i < length; i++) {
            if (nums[i]-1 != i) {
                res = i+1;
                break;
            }
        }
        return res == 0 ? length+1 : res;
    }

    private static void swap(int[] nums, int i, int j) {
        // 交换两个元素
        int tempElement = nums[i];
        nums[i] = nums[j];
        nums[j] = tempElement;
    }
}
