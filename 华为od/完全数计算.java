package 华为od;

import java.util.Scanner;

/**
 * @Author shizq18
 * @Date 2023/6/8
 * @Description
 */
public class 完全数计算 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        int num = in.nextInt();
        int sum = 0;
        int res = 0;
        for(int i = 2; i <= num; i++) {
            if (i % 2 != 0) {
                continue;
            }
            sum = 0;
            for (int j = 1; j < i; j++) {
                if (i % j == 0) {
                    sum += j;
                }
                if (j == i-1 && sum == i) {
                        res++;
                }
            }
        }
        System.out.println(res);
    }
}
