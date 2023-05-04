package 剑指offer100;

import java.util.Arrays;

/**
 * @author shizq18
 * @since 2023/4/26
 */
public class 数组中数字出现的次数 {
    public static void main(String[] args) {
        Arrays.toString(singleNumbers(new int[]{4, 1, 4, 6}));
    }

    /**
     * 一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。
     * 请写程序找出这两个只出现一次的数字。
     */
    public static int[] singleNumbers(int[] nums) {
        //%& 与操作 同为1才为1否则为0
        //^ 异或操作 相同为0，不同为1 可以在一组数中，找不同的那一个
        //问题在于这是两个不同的数，可以找出两个数的不同位的数来分割这两个数
        int length = nums.length;
        int div = 0;
        for (int i = 0; i < length; i++) {
            div ^= nums[i];
        }
        int ret = 1;
        while ((ret & div) == 0) {
            ret = ret << 1;
        }
        //ret 为不同位置
        int numA = 0, numB = 0;
        for (int i = 0; i < length; i++) {
            if ((ret & nums[i]) == 0) {
                numA ^= nums[i];
            } else {
                numB ^= nums[i];
            }
        }
        return new int[]{numA, numB};
    }
}
    /*public static int[] singleNumbers(int[] nums) {
        //HashMap
        int length = nums.length;
        int[] resArray = new int[2];
        int index = 0;
        HashMap<Integer,Integer> numToCount = new HashMap<>();
        for (int i = 0; i < length; i++) {
            Integer count = numToCount.getOrDefault(nums[i],0);
            numToCount.put(nums[i],++count);
        }
        Iterator<Map.Entry<Integer, Integer>> elements = numToCount.entrySet().iterator();
        while (elements.hasNext()){
            Map.Entry<Integer, Integer> currentElement = elements.next();
            if (currentElement.getValue() == 1){
                resArray[index++] = currentElement.getKey();
            }
        }
        return resArray;
    }
}*/
