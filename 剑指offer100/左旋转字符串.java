package 剑指offer100;

/**
 * @Author shizq18
 * @Date 2023/5/4
 * @Description
 */
public class 左旋转字符串 {
    public String reverseLeftWords(String s, int n) {
        StringBuilder stringBuilder = new StringBuilder();
        // 拼接字符串
        for (int i = n; i < s.length(); i++) {
            stringBuilder.append(s.charAt(i));
        }
        for (int i = 0; i < n; i++) {
            stringBuilder.append(s.charAt(i));
        }
        return String.valueOf(stringBuilder);
    }
}
