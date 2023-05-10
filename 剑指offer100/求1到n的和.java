package 剑指offer100;

/**
 * @Author shizq18
 * @Date 2023/5/8
 * @Description
 */
public class 求1到n的和 {
    public static void main(String[] args) {
        System.out.println(sumNums(5));
    }
    public static int sumNums(int n) {
        boolean flag = n > 0 && (n += sumNums(n - 1)) > 0;
        return n;
    }
}
