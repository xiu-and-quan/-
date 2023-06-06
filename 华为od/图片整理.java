package 华为od;

import javax.print.DocFlavor;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @Author shizq18
 * @Date 2023/6/6
 * @Description
 */
public class 图片整理 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        String string = in.nextLine();
        char[] charArray = string.toCharArray();
        Arrays.sort(charArray);
        int[] nums = new int[]{1,2,3};
        Arrays.sort(nums);
        /*String[] strings = new String[]{"a","b"};
        Arrays.sort(strings,(a,b)->a.compareTo(b));*/
        System.out.print(String.valueOf(charArray));
    }
}
