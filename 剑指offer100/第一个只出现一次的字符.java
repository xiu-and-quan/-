package 剑指offer100;

import java.util.HashMap;
import java.util.Map;

/**
 * @author shizq18
 * @since 2023/4/28
 */
public class 第一个只出现一次的字符 {
    public static void main(String[] args) {
        System.out.println(firstUniqChar("leetcode"));
    }
    public static char firstUniqChar(String s) {
        char[] charArray = new char[26];
        int size = s.length();
        for(int i =0; i < size; i++){
            charArray[s.charAt(i)-'a']++;
        }
        for(int i =0; i < size; i++){
            if(charArray[s.charAt(i) - 'a'] == 1){
                return s.charAt(i);
            }
        }
        return ' ';
    }
}
