package 华为od;

/**
 * @Author shizq18
 * @Date 2023/5/26
 * @Description
 */
public class 求int型正整数在内存中存储时1的个数 {
    /*输入一个 int 型的正整数，计算出该 int 型数据在内存中存储时 1 的个数。
    数据范围：保证在 32 位整型数字范围内*/
    public static int solve(int num) {
        int binary = 1;
        int res = 0;
        for (int i = 0; i < 32; i++) {
            if ((num & binary) != 0){
                res++;
            }
            binary <<= 1;
        }
        return res;
    }
}
