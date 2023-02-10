package 动态规划;

import java.util.Arrays;

public class 编辑距离 {
    public static void main(String[] args) {
        System.out.println(minDistance("horse","ros"));
    }
    public static int minDistance(String word1, String word2) {
        //给你两个单词 word1 和 word2，请返回将 word1 转换成 word2 所使用的最少操作数。
        //你可以对一个单词进行如下三种操作：
        //插入一个字符
        //删除一个字符
        //替换一个字符
        int[][] dp = new int[word2.length()+1][word1.length()+1];
        //base case
        for (int i = 0; i < word1.length()+1; i++) {
            dp[0][i] = i;
        }
        for (int i = 0; i < word2.length()+1; i++) {
            dp[i][0] = i;
        }
        //倒着遍历
        for (int i = 0; i < word2.length(); i++) {
            for (int j = 0; j < word1.length(); j++) {
                if (word2.charAt(i) == word1.charAt(j)){
                    dp[i+1][j+1] = dp[i][j];
                }else {
                    //三种选择 插入 删除 替换
                    dp[i+1][j+1] = calculateMin(dp[i][j+1],dp[i][j],dp[i+1][j])+1;
                }
            }
        }

        return dp[word2.length()][word1.length()];
    }

    private static int calculateMin(int num1, int num2, int num3) {
        int minValue = Math.min(num1,num2);
        return Math.min(minValue,num3);
    }
}
