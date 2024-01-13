package 力扣热题100;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @Author shizq18
 * @Date 2024/1/9
 * @Description
 */
public class 多数元素 {
    public int majorityElement(int[] nums) {
        int len = nums.length;
        Map<Integer,Integer> numToCount = new HashMap<>();
        for (int i = 0; i < len; i++) {
            Integer count = numToCount.getOrDefault(nums[i],0);
            numToCount.put(nums[i],count+1);
        }
        int res = nums[0];
        int count = 1;
        Iterator<Map.Entry<Integer,Integer>> iterator= numToCount.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer,Integer> set= iterator.next();
            int current = set.getValue();
            if (current > count) {
                count = current;
                res = set.getKey();
            }
        }
        return res;
    }
}
