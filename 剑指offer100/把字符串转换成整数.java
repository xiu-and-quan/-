package 剑指offer100;

/**
 * @Author shizq18
 * @Date 2023/5/9
 * @Description
 */
public class 把字符串转换成整数 {
    public static void main(String[] args) {
        System.out.println(Integer.valueOf("7"));
    }
    public int strToInt(String str) {
        // 去除空格
        char[] array = str.trim().toCharArray();
        // 判断符号
        int start = 1;
        int sig = 1;
        // 因为从大到小就是乘以10
        int res = 0;
        int maxValue = Integer.MAX_VALUE / 10;
        if (array[0] == '-'){
            sig = -1;
        }else if (array[0] != '+') {
            // 既不是正好也不是负号
            start = 0;
        }
        for (int i = start; i < array.length; i++) {
            // 非数字直接结束
            if (array[i] < '0' || array[i] > '9')  {
                break;
            }
            // 数字的情况 考虑越界问题
            if (res > maxValue || (res == maxValue && array[i] > '7')) {
                return sig == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            res = res * 10 + array[i] - '0';
        }
        return sig * res;
    }
}
