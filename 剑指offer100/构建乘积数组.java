package 剑指offer100;

import java.math.BigDecimal;
import java.util.Arrays;

/**
 * @Author shizq18
 * @Date 2023/5/8
 * @Description
 */
public class 构建乘积数组 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(constructArr(new int[]{1,2,3,4,5})));
    }
    public static int[] constructArr(int[] a) {
        // 对半分 上三角和下三角
        int length = a.length;
        int[] resArray = new int[length];
        // base case
        resArray[0] = 1;
        int temp = 1;
        // 计算左边
        for (int i = 1; i < length; i++) {
            resArray[i] = resArray[i-1]*a[i-1];
        }
        // 计算右边
        for (int i = length-2; i >= 0; i--) {
            temp *= a[i+1];
            resArray[i] *= temp;
        }
        return resArray;
    }
}
