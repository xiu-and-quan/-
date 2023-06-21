package 牛客剑指;

/**
 * @Author shizq18
 * @Date 2023/6/20
 * @Description
 */
public class 斐波那契数列 {
    public int Fibonacci (int n) {
        // write code here
        int pre = 1;
        int next = 1;
        int temp = 1;
        for (int i = 2; i < n; i++) {
            temp = pre + next;
            pre = next;
            next = temp;
        }
        return temp;
    }
}
