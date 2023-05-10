package 剑指offer100;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author shizq18
 * @Date 2023/5/10
 * @Description
 */
public class 把数字翻译成字符串 {
    public static void main(String[] args) {
        System.out.println(translateNum(12258));
    }

    /**
     * 12258
     * 输出: 5
     * 解释: 12258有5种不同的翻译，分别是"bccfi", "bwfi", "bczi", "mcfi"和"mzi"
     */
    public static int translateNum(int num) {
        String stringArray = String.valueOf(num);
        // 动态规划求和
        // num 除以10， 100， 商和余数
        // 余数范围在0到25之间才有输出
        // 爬楼梯问题 一次一步和两步
        int[] dp = new int[stringArray.length()];
        // base case
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i < stringArray.length(); i++) {
            // 有条件的跳一步和两步
            String currentNum = stringArray.substring(i-2, i);
            if (currentNum.compareTo("25") <= 0 && currentNum.compareTo("25") >= 10) {
                dp[i] = dp[i - 1] + dp[i - 2];
            }else {
                dp[i] = dp[i-1];
            }
        }
        return dp[stringArray.length() - 1];
    }
}
