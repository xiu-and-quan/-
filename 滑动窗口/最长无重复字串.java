package 滑动窗口;

import java.util.HashMap;

public class 最长无重复字串 {
    /*输入: s = "abcabcbb"
    输出: 3
    解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。*/
    public static void main(String[] args) {
        String s = "  ";

    }
    public static int lengthOfLongestSubstring(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        int left = 0, right = 0, resLen = 0;
        while(right < s.length()){
            char c = s.charAt(right);
            right++;
            map.put(c,map.getOrDefault(c,0) + 1);
            while(map.get(c) > 1){

                char d = s.charAt(left);
                left++;
                if(map.containsKey(d)){
                    map.put(d,map.getOrDefault(d,0) - 1);
                }
            }
            resLen = Math.max(resLen,right - left);
        }
        return resLen;
    }
}

