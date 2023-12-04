package 力扣热题100;

import java.util.PriorityQueue;

/**
 * @Author shizq18
 * @Date 2023/11/16
 * @Description
 */
public class 数组中的第K个最大元素 {
    public static void main(String[] args) {
        System.out.println(findKthLargest(new int[]{3,2,3,1,2,4,5,5,6},4));
    }
    /*给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
    请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
    你必须设计并实现时间复杂度为 O(n) 的算法解决此问题。
    输入: [3,2,1,5,6,4], k = 2
    输出: 5
    */
    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((x,y)->y-x);
        for (int i = 0; i < nums.length; i++) {
            queue.add(nums[i]);
        }
        int res = nums[0];
        for (int i = 1; i < k; i++) {
            res = queue.poll();
        }
        return res;
    }
}
