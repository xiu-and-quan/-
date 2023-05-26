package 华为od;

import java.util.Scanner;

/**
 * @Author shizq18
 * @Date 2023/5/24
 * @Description
 */
public class 字符串分割 {
    public static void main(String[] args) {
        solve("xvnbbhcfkjxovjwhvwdzhi");
    }
    public static void solve(String string) {
        StringBuilder stringBuilder = new StringBuilder();
        int length = string.length();
        for (int i = 0; i < length; i++) {
            stringBuilder.append(string.charAt(i));
            if ((i+1)%8 == 0) {
                System.out.println(stringBuilder.toString());
                //stringBuilder = new StringBuilder();
                stringBuilder.setLength(0);
            }
        }
        while (stringBuilder.length() < 8 && stringBuilder.length() > 0) {
            stringBuilder.append("0");
            if (stringBuilder.length() == 8) {
                System.out.println(stringBuilder.toString());
            }
        }
    }
}
