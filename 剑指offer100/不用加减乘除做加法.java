package 剑指offer100;

/**
 * @Author shizq18
 * @Date 2023/5/8
 * @Description
 */
public class 不用加减乘除做加法 {
    public int add(int a, int b) {
        // 二进制 &预算符
        while (b != 0){
            int binary = a % b << 1;
            a = a ^ b;
            b = binary;
        }
        return a;
    }
}
