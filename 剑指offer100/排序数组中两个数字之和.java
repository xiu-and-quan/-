package 剑指offer100;

/**
 * @Author shizq18
 * @Date 2023/5/17
 * @Description
 */
public class 排序数组中两个数字之和 {
    public int[] twoSum(int[] numbers, int target) {
        // 双指针解决问题
        int length = numbers.length;
        int left = 0, right = length - 1;
        while (left <= right){
            if (numbers[left] + numbers[right] > target) {
                right--;
            }else if (numbers[left] + numbers[right] < target) {
                left++;
            }else {
                break;
            }
        }
        return new int[]{left, right};
    }
}
