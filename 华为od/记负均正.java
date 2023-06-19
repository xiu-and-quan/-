package 华为od;

import java.util.Scanner;

/**
 * @Author shizq18
 * @Date 2023/6/14
 * @Description
 */
public class 记负均正 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        int size = in.nextInt();
        int negativeCount = 0;
        int positiveCount = 0;
        int average = 0;
        for (int i = 0; i < size; i++) {
            int element = in.nextInt();
            if (element < 0) {
                negativeCount++;
            } else if(element > 0) {
                positiveCount++;
                average += element;
            }
        }
        System.out.print(negativeCount + " ");
        if (positiveCount == 0) {
            System.out.print(0.0);
        }else {
            System.out.print(String.format("%.1f", (float) average / positiveCount));
        }
    }
}
