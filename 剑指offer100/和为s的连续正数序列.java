package 剑指offer100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author shizq18
 * @since 2023/4/28
 */
public class 和为s的连续正数序列 {
    public static void main(String[] args) {
        System.out.println(findContinuousSequence(9));
    }
    public static int[][] findContinuousSequence(int target) {
        // 双指针
        List<int[]> resList = new ArrayList<>();
        int left = 1, right = 2;
        while (right < target){
            // int sum = (right + left) * (right - left + 1)/ 2;
            int sum = (right + 1) * right / 2 - (left + 1) * left / 2;
            if (sum == target){
                int[] currentRes = new int[right - left + 1];
                for (int i = left; i <= right; i++) {
                    currentRes[i - left] = i;
                }
                resList.add(currentRes);
                left++;
            }
            if (sum < target){
                right++;
            }
            if (sum > target){
                left++;
            }
        }
        return resList.toArray(new int[resList.size()][]);
    }
}
