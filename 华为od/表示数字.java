package 华为od;

/**
 * @Author shizq18
 * @Date 2023/6/14
 * @Description
 */
public class 表示数字 {
    public static void main(String[] args) {
        System.out.println(solve("Jkdi234klowe90a3"));
    }
    /*输入：
    Jkdi234klowe90a3
    复制
    输出：
    Jkdi*234*klowe*90*a*3**/
    public static String solve(String string) {
        StringBuilder stringBuilder = new StringBuilder();
        int size = string.length();
        int left = 0, right = 0;
        while (right < size){
            char element = string.charAt(right);
            if (element <= '9' && element >= '0') {
               left = right;
               while (right < size && (string.charAt(right) <= '9' && string.charAt(right) >= '0')) {
                   right++;
               }
               stringBuilder.append("*").append(string.substring(left,right)).append("*");
            } else {
                stringBuilder.append(element);
                right++;
            }
        }
        return stringBuilder.toString();
    }
}
