package 华为od;

import java.util.Scanner;

/**
 * @Author shizq18
 * @Date 2023/6/7
 * @Description
 */
public class 统计每个月兔子的总数 {
    public static void main(String[] args) {
        System.out.println(solve(5));
        /*Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        int month = in.nextInt();
        if (month < 3) {
            System.out.println(1);
        }
        int preNum = 1;
        for (int i = 3; i <= month; i++) {
            if (i % 3 == 0){
                preNum += preNum;
            }
        }
        System.out.println(preNum);*/
    }
    public static int solve(int month){
        int prefirst = 1;
        int preSecond = 1;
        int sum = 1;
        for (int i = 3; i <= month; i++) {
            sum = prefirst + preSecond;
            prefirst = preSecond;
            preSecond = sum;
        }
        return sum;
    }
}
