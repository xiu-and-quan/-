package 华为od;

import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 * @Author shizq18
 * @Date 2023/5/31
 * @Description
 */
public class 删除字符串中出现次数最少的字符 {

    public static void main(String[] args) {
        System.out.println(solve("wvpgggg"));

    }

    public static String solve(String string) {
        int[] smallCharArray = new int[26];
        int length = string.length();
        for (int i = 0; i < length; i++) {
            smallCharArray[string.charAt(i)-'a']++;
        }
        int resIndex = -1;
        int resSmallValue = Integer.MAX_VALUE;
        for (int i = 0; i < 26; i++) {
            if (smallCharArray[i] != 0){
                resSmallValue = Math.min(resSmallValue,smallCharArray[i]);
                if (resSmallValue == smallCharArray[i]){
                    resIndex = i;
                }
            }
        }
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < 26; i++) {
            if (smallCharArray[i] == resSmallValue) {
                set.add((char) (i + 'a'));
            }
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < length; i++) {
            if (!set.contains(string.charAt(i))){
                stringBuilder.append(string.charAt(i));
            }
        }
        return stringBuilder.toString();
    }
}
