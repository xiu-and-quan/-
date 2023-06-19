package 华为od;

import java.util.Scanner;

/**
 * @Author shizq18
 * @Date 2023/6/8
 * @Description
 */
public class 计算日期到天数转换 {
    public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    // 注意 hasNext 和 hasNextLine 的区别
    while (in.hasNextInt()) { // 注意 while 处理多个 case
        int year = in.nextInt();
        int month = in.nextInt();
        int day = in.nextInt();
        int[] dayArray1 = new int[]{0,31,29,31,30,31,30,31,30,31,30,31};
        for (int i = 1; i < 12; i++) {
            dayArray1[i] +=dayArray1[i-1];
        }
        int[] dayArray2 = new int[]{0,31,28,31,30,31,30,31,30,31,30,31};
        for (int i = 1; i < 12; i++) {
            dayArray2[i] +=dayArray2[i-1];
        }
        if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
            System.out.println(dayArray1[month-1]+day);
        }else {
            System.out.println(dayArray2[month-1]+day);
        }
    }
    }
}
