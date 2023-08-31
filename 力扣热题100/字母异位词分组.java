package 力扣热题100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author shizq18
 * @Date 2023/7/18
 * @Description
 */
public class 字母异位词分组 {
    public static void main(String[] args) {
        String[] strs = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> res = groupAnagrams(strs);
        System.out.println(res);
    }
    public static List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0) {
            return null;
        }
        Arrays.sort(strs,(x, y)->{
            char[] x1 = x.toCharArray();
            char[] y1 = y.toCharArray();
            Arrays.sort(x1);
            Arrays.sort(y1);
            return new String(x1).compareTo(new String(y1));
        });
        List<List<String>> resList = new ArrayList<>();
        int left = 0, right = 1;
        while (right < strs.length) {
            if (!isEqual(strs[right],strs[right-1])){
                List<String> temp = new ArrayList<>();
                for (int i = left; i < right; i++) {
                    temp.add(strs[i]);
                }
                left = right;
                resList.add(temp);
            }
            right++;
        }
        List<String> temp = new ArrayList<>();
        for (int i = left; i < right; i++) {
            temp.add(strs[i]);
        }
        resList.add(temp);
        return resList;
    }

    private static boolean isEqual(String x, String y) {
        char[] x1 = x.toCharArray();
        char[] y1 = y.toCharArray();
        Arrays.sort(x1);
        Arrays.sort(y1);
        return new String(x1).equals(new String(y1));
    }
}
