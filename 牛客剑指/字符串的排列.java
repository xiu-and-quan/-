package 牛客剑指;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * @Author shizq18
 * @Date 2023/7/7
 * @Description
 */
public class 字符串的排列 {
    public static void main(String[] args) {
        ArrayList<String> res = Permutation("aa");
        res.forEach(System.out::println);
    }
    static Set<String> resList = new HashSet<>();
    public static ArrayList<String> Permutation (String str) {
        // write code here
        // 全排列 回溯
        char[] chars = str.toCharArray();
        boolean[] isvisited = new boolean[chars.length];
        traver(chars,isvisited,new StringBuilder());
        ArrayList<String> res = new ArrayList<>();
        resList.forEach(r -> res.add(r));
        return res;
    }

    private static void traver(char[] chars, boolean[] isvisited, StringBuilder path) {
        if (path.length() == chars.length) {
            resList.add(path.toString());
            return;
        }
        for (int i = 0; i < chars.length; i++) {
            if (isvisited[i] == false) {
                // 选择
                path.append(chars[i]);
                isvisited[i] = true;
                traver(chars,isvisited,path);
                //撤销选择
                path.deleteCharAt(path.length()-1);
                isvisited[i] = false;
            }
        }
    }
}
