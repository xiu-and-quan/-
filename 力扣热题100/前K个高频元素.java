package 力扣热题100;

import java.util.*;

/**
 * @Author shizq18
 * @Date 2023/11/28
 * @Description
 */
public class 前K个高频元素 {
    public static void main(String[] args) {
        topKFrequent(new int[]{4,1,-1,2,-1,2,3},2);
    }

    /*给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。
        示例 1:
        输入: nums = [1,1,1,2,2,3], k = 2
        输出: [1,2]
        示例 2:
        输入: nums = [1], k = 1
        输出: [1]*/
    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> numToCount = new HashMap<>();
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            count = numToCount.getOrDefault(nums[i],0);
            numToCount.put(nums[i],count+1);
        }
        List<int[]> list = new ArrayList<>();
        numToCount.forEach((key,value) -> list.add(new int[]{key,value}));
        list.sort((x,y)->y[1]-x[1]);
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = list.get(i)[0];
        }
        return res;
    }
}
