package 剑指offer100;

public class 数字序列中某一位的数字 {
    public static void main(String[] args) {
        System.out.println(findNthDigit(0));
    }
    public static int findNthDigit(int n) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i <= n; i++) {
            stringBuilder.append(i);
        }
        return stringBuilder.toString().charAt(n) - '0';
    }
}
