package 华为od;

import java.util.Scanner;

/**
 * @Author shizq18
 * @Date 2023/6/14
 * @Description
 */
public class 记负均正II {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        int negativeCount = 0;
        int postiveCount = 0;
        int average = 0;
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int a = in.nextInt();
            if (a < 0) {
                negativeCount++;
            } else if (a > 0) {
                postiveCount++;
                average += a;
            }
        }
        System.out.println(negativeCount);
        if (postiveCount == 0) {
            System.out.println(0.0);
        } else {
            System.out.println(String.format("%.1f",(float)average/postiveCount));
        }
    }
}
