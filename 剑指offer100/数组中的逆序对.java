package 剑指offer100;

import java.util.Arrays;

/**
 * 数组中的逆序对
 * @author shizq18
 * @since 2023/4/21
 */
public class 数组中的逆序对 {
    public static void main(String[] args) {
        System.out.println(reversePairs(new int[]{4,5,6,7}));
    }
    public static int reversePairs(int[] nums) {
        int size = nums.length;
        int[][] valueToIndex = new int[size][2];
        for (int i = 0; i < size; i++) {
            valueToIndex[i] = new int[]{nums[i],i};
        }
        int res = 0;
        Arrays.sort(valueToIndex,(x, y)-> y[0] - x[0]);
        for (int i = 0; i < size; i++) {
            if ((size - 1 - valueToIndex[i][1]) <= (size - 1 - i)){
                res+=size - 1 - valueToIndex[i][1];
            }else {
                res+=size - 1 - i;
            }
        }
        return res;
    }
}
