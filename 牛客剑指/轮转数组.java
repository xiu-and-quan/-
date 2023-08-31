package 牛客剑指;

/**
 * @Author shizq18
 * @Date 2023/8/3
 * @Description
 */
public class 轮转数组 {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7};
        rotate(nums, 3);
        System.out.println(nums);
    }
    public static void rotate(int[] nums, int k) {
        int length = nums.length;
        int[] res = new int[length];
        for (int i = 0; i < length; i++) {
            res[(i+k) % length] = nums[i];
        }
        nums = res;
    }
}
