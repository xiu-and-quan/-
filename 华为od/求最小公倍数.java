package 华为od;

import java.util.Scanner;

/**
 * @Author shizq18
 * @Date 2023/6/14
 * @Description
 */
public class 求最小公倍数 {
    public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int a = in.nextInt();
            int b = in.nextInt();
            int big = Math.max(a, b);
            int small = Math.min(a, b);
            if (big % small == 0) {
                System.out.println(big);
            }else {
                for (int i = big; i <= a*b; i++) {
                    if (i % a == 0 && i % b == 0) {
                        System.out.println(i);
                        break;
                    }
                }
            }
        }
    }
}
