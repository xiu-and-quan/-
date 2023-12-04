package 力扣热题100;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @Author shizq18
 * @Date 2023/10/13
 * @Descriptionmk
 */
public class 分割回文串 {
    public static void main(String[] args) {
        List<List<String>> res = partition(new String("aabb"));
        System.out.println("success!");
    }
    /**
     * 给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。
     * 回文串 是正着读和反着读都一样的字符串。
     * 示例 1：
     * 输入：s = "aab"
     * 输出：[["a","a","b"],["aa","b"]]
     * 示例 2：
     * 输入：s = "a"
     * 输出：[["a"]]
     */
    public static List<List<String>> partition(String s) {
        char[] charArray = s.toCharArray();
        int len = charArray.length;
        List<List<String>> resPath = new ArrayList<>();
        List<String> path = new ArrayList<>();
        traver(charArray, 0, path, resPath, len);
        return resPath;
    }

    private static void traver(char[] charArray, int start, List<String> path, List<List<String>> resPath, int len) {
        if(start == len) {
            resPath.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i < len; i++) {
            if (isVaild(charArray, start, i)) {
                path.add(new String(charArray, start, i+1-start));
                traver(charArray, i+1, path, resPath, len);
                path.remove(path.size()-1);
            }
        }
    }

    /**
     * 回文串的合法性
     */
    private static boolean isVaild(char[] charArray, int start, int end) {
        while (start < end) {
            if (charArray[start] == charArray[end]) {
                start++;
                end--;
            } else {
                return false;
            }
        }
        return true;
    }
    public static List<List<String>> partition1(String s) {
        int len = s.length();
        List<List<String>> res = new ArrayList<>();
        if (len == 0) {
            return res;
        }
        List<String> path = new ArrayList<>();
        char[] charArray = s.toCharArray();
        dfs(charArray, 0, len, path, res);
        return res;
    }

    /**
     * @param charArray
     * @param index     起始字符的索引
     * @param len       字符串 s 的长度，可以设置为全局变量
     * @param path      记录从根结点到叶子结点的路径
     * @param res       记录所有的结果
     */
    private static void dfs(char[] charArray, int index, int len, List<String> path, List<List<String>> res) {
        if (index == len) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = index; i < len; i++) {
            // 因为截取字符串是消耗性能的，因此，采用传子串下标的方式判断一个子串是否是回文子串
            if (!checkPalindrome(charArray, index, i)) {
                continue;
            }
            path.add(new String(charArray, index, i + 1 - index));
            dfs(charArray, i + 1, len, path, res);
            path.remove(path.size()-1);
        }
    }

    /**
     * 这一步的时间复杂度是 O(N)，优化的解法是，先采用动态规划，把回文子串的结果记录在一个表格里
     *
     * @param charArray
     * @param left      子串的左边界，可以取到
     * @param right     子串的右边界，可以取到
     * @return
     */
    private static boolean checkPalindrome(char[] charArray, int left, int right) {
        while (left < right) {
            if (charArray[left] != charArray[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

}

