package 华为od;

import java.util.Scanner;

/**
 * @Author shizq18
 * @Date 2023/5/24
 * @Description
 */
public class 计算某字符出现次数 {
    public static void main(String[] args) {
        System.out.println(findTheSameCharacterCount("abcABC","A"));

    }
    public static int findTheSameCharacterCount(String one, String two){
        int length = one.length();
        int res = 0;
        for (int i = length-1; i >= 0; i--) {
            char currentCharacter = one.charAt(i);
            String currentString = String.valueOf(currentCharacter);
            if (two.toLowerCase().equals(currentString)
                    || two.toUpperCase().equals(currentString)) {
                res++;
            }
        }
        return res;
    }
}
