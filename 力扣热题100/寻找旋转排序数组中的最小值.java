package 力扣热题100;

/**
 * @Author shizq18
 * @Date 2023/10/23
 * @Description
 */
public class 寻找旋转排序数组中的最小值 {
    public static void main(String[] args) {
        int res = findMin(new int[]{4,5,1,2,3});
        System.out.println(res);
    }
    /**
     * 已知一个长度为 n 的数组，预先按照升序排列，经由 1 到 n 次 旋转 后，得到输入数组。例如，原数组 nums = [0,1,2,4,5,6,7] 在变化后可能得到：
     * 若旋转 4 次，则可以得到 [4,5,6,7,0,1,2]
     * 若旋转 7 次，则可以得到 [0,1,2,4,5,6,7]
     * [5,6,7,1,2]
     * 注意，数组 [a[0], a[1], a[2], ..., a[n-1]] 旋转一次 的结果为数组 [a[n-1], a[0], a[1], a[2], ..., a[n-2]] 。
     *
     * 给你一个元素值 互不相同 的数组 nums ，它原来是一个升序排列的数组，并按上述情形进行了多次旋转。请你找出并返回数组中的 最小元素 。
     *
     * 你必须设计一个时间复杂度为 O(log n) 的算法解决此问题。
     */
    public static int findMin(int[] nums) {
        int len = nums.length;
        int left = 0;
        int right = len-1;
        while (left < right) {
            if (nums[left] < nums[right]) {
                return left;
            }
            int middle = (left+right)/2;
            if (nums[middle] >= nums[left]) {
                left = middle + 1;
            } else {
                right = middle;
            }
            /*if (nums[left] < nums[middle]) {
                if (nums[middle] < nums[right]) {
                    right = middle;
                } else {
                    // 3 4 5 1 2
                    left = middle+1;
                }
            } else {
                // 5 6 7 1 2 3
                if (nums[middle] < nums[right]) {
                    left = middle;
                }
            }*/
        }
        if (left + 1 >= len) {
            return nums[left];
        } else {
            return nums[left] < nums[left+1] ? nums[left] : nums[left+1];
        }
    }
}
