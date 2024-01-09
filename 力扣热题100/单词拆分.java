package 力扣热题100;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author shizq18
 * @Date 2023/12/13
 * @Description
 */
public class 单词拆分 {
    public static void main(String[] args) {
        List<String> wordDict = new ArrayList<>();
//        wordDict.add("leet");
//        wordDict.add("code");
        wordDict.add("a");
        boolean res = wordBreak1("a",wordDict);
        System.out.println(res);
    }

    public static boolean wordBreak1(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>();
        wordDict.forEach(x->set.add(x));
        int len = s.length();
        boolean[] dp = new boolean[len+1];
        // 没开始等于真
        dp[0] = true;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j <= i; j++) {
                if (set.contains(s.substring(j,i+1))) {
                    dp[i+1] |= dp[j];
                }
            }
        }
        return dp[len];
    }
    public static boolean wordBreak(String s, List<String> wordDict) {
        // dfs
        Set<String> set = new HashSet<>();
        wordDict.forEach(x->set.add(x));
        int start = 0;
        int len = s.length();
        boolean[] memo = new boolean[len];
        return dfs(s, start, len, set, memo);
    }

    /**
     * 判断是否包含
     */
    public static boolean dfs(String s, int start, int len, Set<String> set, boolean[] memo) {
        // 匹配完返回true
        if (start >= len) {
            return true;
        }
        if (memo[start]) {
            return true;
        }
        // 拼接字符
        for (int i = start; i < len; i++) {
            String currentString = s.substring(start,i+1);
            if (set.contains(currentString)) {
                memo[start] = true;
                if(dfs(s,i+1,len,set,memo)) {
                    return true;
                }
            }
        }
        return false;
    }
}
