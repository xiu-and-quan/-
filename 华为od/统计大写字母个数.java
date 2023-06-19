package 华为od;

import java.util.Scanner;

/**
 * @Author shizq18
 * @Date 2023/6/13
 * @Description
 */
public class 统计大写字母个数 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        String string = in.nextLine();
        int resCount = 0;
        for (int i = 0; i < string.length(); i++) {
            char element = string.charAt(i);
            if (element >= 'A' && element <= 'Z') {
                resCount++;
            }
        }
        System.out.println(resCount);
    }
}
