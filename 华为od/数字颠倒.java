package 华为od;

/**
 * @Author shizq18
 * @Date 2023/5/26
 * @Description
 */
public class 数字颠倒 {
    /*输入一个整数，将这个整数以字符串的形式逆序输出
        程序不考虑负数的情况，若数字含有0，则逆序形
        式也含有0，如输入为100，则输出为001*/
    public static String solve(int num) {
        String numString = String.valueOf(num);
        int length = numString.length();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = length-1; i >= 0; i--) {
            stringBuilder.append(numString.charAt(i));
        }
        return stringBuilder.toString();
    }
}
