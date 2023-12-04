package java相关测试;

/**
 * @Author shizq18
 * @Date 2023/9/21
 * @Description
 */
public class FinalTest {
    public static void main(String[] args) {
        final int var1 = 9;
        // java: 无法为最终变量var1分配值
        // var1 = 10;
        System.out.println(var1);
    }
}
