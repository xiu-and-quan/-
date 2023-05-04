package 剑指offer100;

public class 一到n整数中1出现的次数 {
    public static void main(String[] args) {
        System.out.println(countDigitOne(12));
    }
    public static int countDigitOne(int n) {
        int res = 0;
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int count = containsOneCount(String.valueOf(i).toCharArray());
            res += count;
        }
        return res;
    }

    private static int containsOneCount(char[] array) {
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if ('1'== array[i]){
                count++;
            }
        }
        return count;
    }
}
