package 前缀和数组;

import java.util.ArrayList;
import java.util.List;

public class 区域和检索数组不可变 {
    /*给定一个整数数组  nums，处理以下类型的多个查询:
    计算索引 left 和 right （包含 left 和 right）之间的 nums 元素的 和 ，其中 left <= right
    实现 NumArray 类：
    NumArray(int[] nums) 使用数组 nums 初始化对象
    int sumRange(int i, int j) 返回数组 nums 中索引 left 和 right 之间的元素的 总和 ，包含 left 和 right 两点（也就是 nums[left] + nums[left + 1] + ... + nums[right] )
    输入：
    ["NumArray", "sumRange", "sumRange", "sumRange"]
    [[[-2, 0, 3, -5, 2, -1]], [0, 2], [2, 5], [0, 5]]
    输出：
    [null, 1, -1, -3]

    解释：
    NumArray numArray = new NumArray([-2, 0, 3, -5, 2, -1]);
    numArray.sumRange(0, 2); // return 1 ((-2) + 0 + 3)
    numArray.sumRange(2, 5); // return -1 (3 + (-5) + 2 + (-1))
    numArray.sumRange(0, 5); // return -3 ((-2) + 0 + 3 + (-5) + 2 + (-1))
    */
    public static void main(String[] args) {
        int[] test = new int[]{1,2,3,4,5,6,7,8,9,10};
        NumArray numArray = new NumArray(test);
        int res = numArray.sumRange(0,2);
        System.out.println(res);
    }
}
class NumArray {
    public int[] sums;
    public NumArray(int[] nums) {
        //想法 设置一个数组，每个数组的索引位置就是第0个元素到第n个位置的总和
        sums = new int[nums.length+1];
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res += nums[i];
            sums[i+1] = res;
        }
    }

    public int sumRange(int left, int right) {
        return sums[right+1] - sums[left];
    }
}