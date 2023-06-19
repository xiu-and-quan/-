package 华为od;

import java.util.Scanner;

/**
 * @Author shizq18
 * @Date 2023/6/7
 * @Description
 */
public class 统计字符 {
    /*统计其中英文字符，空格字符，数字字符，其他字符的个数*/
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        String string = in.nextLine();
        int length = string.length();
        int charCount = 0, spaceCount = 0, numCount = 0, otherCount = 0;
        for (int i = 0; i < length; i++) {
            if ((string.charAt(i) >= 'a' && string.charAt(i) <= 'z')
                    || (string.charAt(i) >= 'A' && string.charAt(i) <= 'Z')) {
                charCount++;
            }else if (string.charAt(i) >= '0' && string.charAt(i) <= '9') {
                numCount++;
            }else if (string.charAt(i) == ' ') {
                spaceCount++;
            }else {
                otherCount++;
            }
        }
        System.out.println(charCount);
        System.out.println(spaceCount);
        System.out.println(numCount);
        System.out.println(otherCount);
    }
}
