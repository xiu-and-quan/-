package 力扣热题100;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author shizq18
 * @Date 2023/12/6
 * @Description
 */
public class 划分字母区间 {
    /*输入：s = "ababcbacadefegdehijhklij"
    输出：[9,7,8]
    解释：
    划分结果为 "ababcbaca"、"defegde"、"hijhklij" 。
    每个字母最多出现在一个片段中。
    像 "ababcbacadefegde", "hijhklij" 这样的划分是错误的，因为划分的片段数较少。*/
    public List<Integer> partitionLabels(String s) {
        int[] last = new int[26];
        int length = s.length();
        for (int i = 0; i < length; i++) {
            last[s.charAt(i) - 'a'] = i;
        }
        List<Integer> partition = new ArrayList<Integer>();
        int start = 0, end = 0;
        for (int i = 0; i < length; i++) {
            end = Math.max(end, last[s.charAt(i) - 'a']);
            if (i == end) {
                partition.add(end - start + 1);
                start = end + 1;
            }
        }
        return partition;
    }
}
