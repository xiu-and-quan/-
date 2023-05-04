package 剑指offer100;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author shizq18
 * @since 2023/4/21
 */
public class 把数组排成最小的数 {
    public static void main(String[] args) {
        System.out.println("A".compareTo("B"));
        Integer[] arr = {5,4,7,9,2,12,54,21,1};
        //降序
        Arrays.sort(arr, new Comparator<Integer>() {
            public int compare(Integer a, Integer b) {
                return b-a;
            }
        });
    }

    /**
     *  关键点在于 x + y > y + x 说明x >  y
     * @param nums
     * @return
     */
    public String minNumber(int[] nums) {
        String[] strs = new String[nums.length];
        for(int i = 0; i < nums.length; i++) {
            strs[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(strs, (x, y) -> (x + y).compareTo(y + x));
        StringBuilder res = new StringBuilder();
        for(String s : strs)
            res.append(s);
        return res.toString();
    }
}
