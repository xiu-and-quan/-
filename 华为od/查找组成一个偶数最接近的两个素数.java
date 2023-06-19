package 华为od;

import java.util.Scanner;

/**
 * @Author shizq18
 * @Date 2023/6/8
 * @Description
 */
public class 查找组成一个偶数最接近的两个素数 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        int num = in.nextInt();
        int[] res = solve(num);
        System.out.println(res[0]);
        System.out.println(res[1]);
    }

    public static int[] solve(int num) {
        int[] res = new int[2];
        int minDifference = num;
        for (int i=1;i<=num/2;i++) {
            if (isPrimeNumber(i) && isPrimeNumber(num-i)) {
                if (minDifference > num-2*i){
                    res[0] = i;
                    res[1] = num-i;
                }
            }
        }
        return res;
    }

    private static boolean isPrimeNumber(int num) {
        if (num == 1) {
            return true;
        }
        // 判断是否为素数，只有1和他本身
        int count = 0;
        for (int i = 1; i < num; i++) {
            if (num % i == 0) {
                count++;
            }
            if (count > 1) {
                return false;
            }
        }
        return true;
    }
}