package 剑指offer100;

/**
 * @Author shizq18
 * @Date 2023/5/18
 * @Description
 */
public class 乘积小于K的子数组 {
    public static void main(String[] args) {
        System.out.println(numSubarrayProductLessThanK2(new int[]{1, 2, 3}, 0));
    }

    /**
     * 倒着寻找
     * @param nums
     * @param k
     * @return
     */
    public static int numSubarrayProductLessThanK2(int[] nums, int k) {
        int length = nums.length;
        int res = 1, resCount = 0;
        int startIndex = 0;
        for (int end = 0; end < length; end++) {
            res *= nums[end];
            while (startIndex <= end && res >= k) {
                res /= nums[startIndex];
                startIndex++;
            }
            resCount += end - startIndex + 1;
        }
        return resCount;
    }

    /**
     * 考虑外层是for循环，内层双指针
     */
    public static int numSubarrayProductLessThanK1(int[] nums, int k) {
        int length = nums.length;
        int res = 1, resCount = 0;
        for (int i = 0; i < length; i++) {
            res = 1;
            for (int j = i; j < length; j++) {
                if (res > k){
                    break;
                }
                if (i == j) {
                    res *= nums[i];
                } else {
                    res *= nums[j];
                }
                if (res < k) {
                    resCount++;
                }
            }
        }
        return resCount;
    }

        /**
         * 乘法会导致乘积大于Integer.MAX_VALUE
         * @param nums
         * @param k
         * @return
         */
    public static int numSubarrayProductLessThanK(int[] nums, int k) {
        int length = nums.length;
        int[] produceBefore = new int[length];
        int res = 1;
        for (int i = 0; i < length; i++) {
            res *= nums[i];
            produceBefore[i] = res;
        }
        int resCount = 0;
        // 斜着遍历 按照数组长度来
        // 第一层是长度
        for (int i = 1; i <= length; i++) {
            // 第二层是开始位置
            for (int j = 0; j <= length-1; j++) {
                int right = j + i - 1;
                // 考虑右边界越界问题
                if (right < length){
                    if (j == 0){
                        if (produceBefore[right] < k){
                            resCount++;
                        }
                    }else {
                        if (produceBefore[right] / produceBefore[j-1] < k){
                            resCount++;
                        }
                    }
                }
            }
        }
        return resCount;
    }
}
