package 华为od;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author shizq18
 * @Date 2023/6/1
 * @Description
 */
public class 密码验证合格程序 {
    /*密码要求:
    1.长度超过8位
    2.包括大小写字母.数字.其它符号,以上四种至少三种
    3.不能有长度大于2的包含公共元素的子串重复 （注：其他符号不含空格或换行）*/
    public String solve(String string) {
        int length = string.length();
        if (length <= 8){
            return "NG";
        }
        Set<Integer> set = new HashSet<>();
        // 1 小写字母；2 大写字符；3 数字； 4 其他字符
        for (int i = 0; i < length; i++) {
            if (string.charAt(i) >= 'a' && string.charAt(i) <= 'z') {
                set.add(1);
            }else if (string.charAt(i) >= 'A' && string.charAt(i) <= 'Z') {
                set.add(2);
            }else if (string.charAt(i) >= '1' && string.charAt(i) <= '9') {
                set.add(3);
            }else {
                set.add(4);
            }
            if (set.size()<3){
                return "NG";
            }
        }
        return null;
    }
}
