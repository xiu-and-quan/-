package 剑指offer100;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author shizq18
 * @Date 2023/5/22
 * @Description
 */
public class 零和1个数相同的子数组 {
    public static void main(String[] args) {
        System.out.println(findMaxLength(new int[]{0,1}));
    }

    public static int findMaxLength(int[] nums) {
        int maxLength = 0;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int counter = 0;
        map.put(counter, -1);
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            if (num == 1) {
                counter++;
            } else {
                counter--;
            }
            if (map.containsKey(counter)) {
                int prevIndex = map.get(counter);
                maxLength = Math.max(maxLength, i - prevIndex);
            } else {
                map.put(counter, i);
            }
        }
        return maxLength;
    }
}
