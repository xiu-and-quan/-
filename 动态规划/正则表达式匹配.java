package 动态规划;

public class 正则表达式匹配 {
    public static void main(String[] args) {
        System.out.println(isMatch("a","..*"));
    }
    /*给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
     '.' 匹配任意单个字符
     '*' 匹配零个或多个前面的那一个元素
     所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。*/
    public static boolean isMatch(String s, String p) {
        //明确dp的定义
        int length1 = s.length();
        int length2 = p.length();
        boolean[][] dp = new boolean[length1+1][length2+1];
        //base case
        dp[0][0] = true;
        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == '*'){
                dp[0][i+1] = dp[0][i-1];
            }
        }
        //p匹配s
        //遍历状态
        for (int i = 0; i < length1; i++) {
            for (int j = 0; j < length2; j++) {
                if (p.charAt(j) == '*'){
                    if (j-1 >= 0){
                        if (p.charAt(j-1) == '.' || p.charAt(j-1) == s.charAt(i)){
                            dp[i+1][j+1] = dp[i+1][j-1] || dp[i][j+1];
                        }else {
                            dp[i+1][j+1] = dp[i+1][j-1];
                        }
                    }else {
                        dp[i+1][j+1] = false;
                    }
                }else {
                    if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.'){
                        dp[i+1][j+1] = dp[i][j];
                    }else {
                        dp[i+1][j+1] = false;
                    }
                }
            }
        }
        return dp[length1][length2];
    }
}

