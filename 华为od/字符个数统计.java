package 华为od;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author shizq18
 * @Date 2023/5/26
 * @Description
 */
public class 字符个数统计 {
    public static void main(String[] args) {
        System.out.println(solve("aaa"));
    }
    /*编写一个函数，计算字符串中含有的不同字符的个数。字符在 ASCII 码范围内( 0~127 ，包括 0 和 127 )，换行表示结束符，不算在字符里。不在范围内的不作统计。多个相同的字符只计算一次
例如，对于字符串 abaca 而言，有 a、b、c 三种不同的字符，因此输出 3 。*/
    public static int solve(String string){
        Set<Character> set = new HashSet<>();
        int length = string.length();
        for (int i = 0; i < length; i++) {
            set.add(string.charAt(i));
        }
        return set.size();
    }
}
