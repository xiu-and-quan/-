package 华为od;

import java.util.Scanner;

/**
 * @Author shizq18
 * @Date 2023/6/8
 * @Description
 */
public class 百钱买百鸡问题 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        for(int i = 0; i<20; i++) {
            for (int j = 0; j < 36; j++) {
                int k = 100 - i -j;
                if (k % 3 == 0) {
                    if (5*i + 3*j + k/3 == 100){
                        System.out.print(i + " " + j + " " + k);
                        System.out.println();
                    }
                }
            }
        }
    }
}
