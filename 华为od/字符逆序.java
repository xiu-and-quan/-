package 华为od;

import java.util.Scanner;

/**
 * @Author shizq18
 * @Date 2023/6/14
 * @Description
 */
public class 字符逆序 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String string = in.next();
        StringBuilder stringBuilder = new StringBuilder();
        int size = string.length();
        for (int i = size-1; i >= 0; i--) {
            stringBuilder.append(string.charAt(i));
        }
        System.out.println(stringBuilder.toString());
    }
}
