package 华为od;

import java.util.Scanner;

/**
 * @Author shizq18
 * @Date 2023/5/30
 * @Description
 */
public class 简单密码 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        String string = in.nextLine();
        int length = string.length();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < length; i++) {
            if (string.charAt(i)<='9' && string.charAt(i) >= '0'){
                stringBuilder.append(string.charAt(i));
            }
            if (string.charAt(i)<='z' && string.charAt(i) >= 'a'){
                char num= smallCharacterToNum(string.charAt(i));
                stringBuilder.append(num);
            }
            if (string.charAt(i)<='Z' && string.charAt(i) >= 'A'){
                char num= bigCharacterToNum(string.charAt(i));
                stringBuilder.append(num);
            }
        }
        System.out.println(stringBuilder.toString());

    }

    private static char bigCharacterToNum(char big) {
        int res = big - 'A' + 'a';
        if (res == 'z'){
            return 'a';
        }else {
            res++;
            return (char) res;
        }
    }

    private static char smallCharacterToNum(char character) {
        if (character-'w' >= 0){
            return '9';
        } else if (character-'t' >= 0) {
            return '8';
        }else if (character-'p' >= 0) {
            return '7';
        }else if (character-'m' >= 0) {
            return '6';
        }else if (character-'j' >= 0) {
            return '5';
        }else if (character-'g' >= 0) {
            return '4';
        }else if (character-'d' >= 0) {
            return '3';
        }else {
            return '2';
        }
    }
}
