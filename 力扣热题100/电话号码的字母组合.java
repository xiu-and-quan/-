package 力扣热题100;

import javax.print.DocFlavor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author shizq18
 * @Date 2023/9/22
 * @Description
 */
public class 电话号码的字母组合 {
    public static void main(String[] args) {
        letterCombinations("4");
    }
    static List<String> resList = new ArrayList<>();
    static Map<Character,char[]> map = new HashMap<>();
    public static List<String> letterCombinations(String digits) {
        char[] chars = digits.toCharArray();
        int length = chars.length;
        if (length == 0) {
            return resList;
        }
        StringBuilder path = new StringBuilder();
        map.put('2',new char[]{'a','b','c'});
        map.put('3',new char[]{'d','e','f'});
        map.put('4',new char[]{'g','h','i'});
        map.put('5',new char[]{'j','k','l'});
        map.put('6',new char[]{'m','n','o'});
        map.put('7',new char[]{'p','q','r','s'});
        map.put('8',new char[]{'t','u','v'});
        map.put('9',new char[]{'w','x','y','z'});
        traver(chars,path,0);
        return resList;
    }

    private static void traver(char[] chars, StringBuilder path,int start) {
        if (path.length() == chars.length) {
            resList.add(new String(path));
        }
        for (int i = start; i < chars.length; i++) {
            char[] currentChars = map.get(chars[i]);
            for (char c:
                 currentChars) {
                path.append(c);
                traver(chars,path,i+1);
                path.deleteCharAt(path.length()-1);
            }
        }
    }
}
