package 华为od;

/**
 * @Author shizq18
 * @Date 2023/5/26
 * @Description
 */
public class 字符串反转 {
    /*接受一个只包含小写字母的字符串，然后输出该字符串反转后的字符串。（字符串长度不超过1000）*/
    public static String solve(String string) {
        int length = string.length();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = length-1; i >= 0; i--) {
            stringBuilder.append(string.charAt(i));
        }
        return stringBuilder.toString();
    }
}
