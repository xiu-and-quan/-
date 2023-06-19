package 华为od;

import java.util.Scanner;

/**
 * @Author shizq18
 * @Date 2023/6/8
 * @Description
 */
public class 查找输入整数二进制中1的个数 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        int num = in.nextInt();
        System.out.println(solve(num));
    }

    public static int solve(int num) {
        int res = 0, temp = 1;
        for (int i = 0; i < 32; i++) {
            if ((num & temp) != 0){
                res++;
            }
            temp <<= 1;
        }
        return res;
    }
}
