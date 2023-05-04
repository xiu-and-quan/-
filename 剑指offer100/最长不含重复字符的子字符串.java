package 剑指offer100;


import java.util.HashMap;
import java.util.Map;

public class 最长不含重复字符的子字符串 {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring(" "));
    }
    public static int lengthOfLongestSubstring(String s) {
        int size = s.length();
        //设动态规划列表 dp，dp[j] 代表以字符 s[j]为结尾的 “最长不重复子字符串”
        int[] dp = new int[size+1];
        Map<Character,Integer> charToIndex = new HashMap<>();
        int res = 0;
        for (int i = 0; i < size; i++) {
            int repeatCharIndex = charToIndex.getOrDefault(s.charAt(i), -1); // 获取索引 i
            charToIndex.put(s.charAt(i), i); // 更新哈希表
            dp[i+1] = dp[i] < i - repeatCharIndex ? dp[i] + 1 : i - repeatCharIndex; // dp[j - 1] -> dp[j]
            res = Math.max(res, dp[i+1]); // max(dp[j - 1], dp[j])
        }
        return res;
    }
}
