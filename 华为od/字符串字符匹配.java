package 华为od;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @Author shizq18
 * @Date 2023/6/9
 * @Description
 */
public class 字符串字符匹配 {

    public static void main(String[] args) {
        /*Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        String s1 = in.next();
        String s2 = in.next();*/
        System.out.println(solve("okekwgktczxeposiirjmquypjbohexyinlktaunjyhkjw",
                "yjynxoawaobtbpyxhbqpzdqjehydzfistxtlzrqzdotglpcunfmpvaparnxkmsybwo"));
    }
    public static boolean solve(String s1, String s2) {
        int length1 = s1.length();
        int length2 = s2.length();
        // 有重复的
        int[] charArray = new int[26];
        for (int i = 0; i < length1; i++) {
            charArray[s1.charAt(i)-'a']=1;
        }
        for (int i = 0; i < length2; i++) {
            if (charArray[s2.charAt(i)-'a'] == 1) {
                charArray[s2.charAt(i)-'a'] = 0;
            }
        }
        for (int i = 0; i < 26; i++) {
            if (charArray[i] != 0){
                return false;
            }
        }
        return true;
    }
}
