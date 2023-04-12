package 剑指offer100;

import java.util.Arrays;

public class 打印从1到最大的n位数 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(printNumbers(2)));
    }
    public static int[] printNumbers(int n) {
        double maxValue = Math.pow(10,n)-1;
        int[] res = new int[(int)maxValue];
        for (int i = 0; i < maxValue; i++) {
            res[i] = i+1;
        }
        return res;
    }
}
