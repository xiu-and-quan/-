package 华为od;

import java.util.Scanner;

/**
 * @Author shizq18
 * @Date 2023/6/7
 * @Description
 */
public class 截取字符串 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        String strings = in.nextLine();
        int size = in.nextInt();
        String res = strings.substring(size);
        System.out.println(res);
    }
}
