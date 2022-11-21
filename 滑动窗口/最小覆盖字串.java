package 滑动窗口;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class 最小覆盖字串 {
    /*给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。
    如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
    示例 1：
    输入：s = "ADOBECODEBANC", t = "ABC"
    输出："BANC"
    示例 2：

    输入：s = "a", t = "a"
    输出："a"
    示例 3:

    输入: s = "a", t = "aa"
    输出: ""
    解释: t 中两个字符 'a' 均应包含在 s 的子串中，
    因此没有符合条件的子字符串，返回空字符串。*/
    public static void main(String[] args) {

        String res = minWindow("a","a");
        System.out.printf(res);
    }



    public static String minWindow(String s, String t) {
        char[] s1 = s.toCharArray();
        char[] t1 = t.toCharArray();
        int left = 0, right = 0, len = 0, resLength = Integer.MAX_VALUE, resLeft = 0;
        //记录窗口
        HashMap<Character,Integer> maping = new HashMap<>();
        //已有窗口数据 t字符串的
        HashMap<Character,Integer> maped = new HashMap<>();
        for (int i = 0; i < t1.length; i++) {
            maped.put(t1[i],maped.getOrDefault(t1[i],0) + 1);
        }
        int totalSize = maped.size();
        /*System.out.println(totalSize);
        Iterator<Map.Entry<Character, Integer>> temp = maped.entrySet().iterator();
        while (temp.hasNext()){
            System.out.println(temp.next());
        }*/
        while (right < s1.length){
            char c = s1[right];
            right++;
            if (maped.containsKey(c)){
                maping.put(c,maping.getOrDefault(c,0) + 1);
                if (maped.get(c).equals(maping.get(c))) {
                    len++;
                }
                //何时收缩左边窗口 当maping和mapped相同时
                while (len == totalSize){
                    if(resLength > right - left){
                        resLength = right - left;
                        resLeft = left;
                    }
                    char d = s1[left];
                    left++;
                    if (maped.containsKey(d)){
                        if (maped.get(d).equals(maping.get(d))){
                            len--;
                        }
                        maping.put(d,maping.get(d)-1);
                    }
                }
            }

        }
        return resLength == Integer.MAX_VALUE ? "" : s.substring(resLeft,resLeft + resLength);
    }
}
