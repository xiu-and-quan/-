package 华为od;

import java.util.Scanner;

/**
 * @Author shizq18
 * @Date 2023/6/13
 * @Description
 */
public class 二维数组操作 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNext()) { // 注意 while 处理多个 case
            int rowLength = in.nextInt();
            int colLength = in.nextInt();
            int rowOld = in.nextInt();
            int colOld = in.nextInt();
            int rowNew = in.nextInt();
            int colNew = in.nextInt();
            int insertRow = in.nextInt();
            int insertCol = in.nextInt();
            int searchRow = in.nextInt();
            int colSearch = in.nextInt();
            if (rowLength <= 9 && colLength <= 9) {
                System.out.println(0);
            }else {
                System.out.println(-1);
            }
            if (rowOld >= rowLength || rowOld < 0 || colOld >= colLength || colOld < 0 ||
                rowNew >= rowLength || rowNew < 0 || colNew >= colLength || colNew < 0) {
                System.out.println(-1);
            } else {
                System.out.println(1);
            }

            if (insertRow < rowLength && rowLength < 9) {
                System.out.println(0);
            }else {
                System.out.println(-1);
            }
            if (insertCol < colLength && colLength < 9) {
                System.out.println(0);
            }else {
                System.out.println(-1);
            }

            if (searchRow >= 0 && searchRow < rowLength && colSearch >= 0 && colSearch < colLength) {
                System.out.println(0);
            } else {
                System.out.println(-1);
            }
        }
    }
}
