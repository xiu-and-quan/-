package 华为od;

import java.util.Scanner;

/**
 * @Author shizq18
 * @Date 2023/6/14
 * @Description
 */
public class 自守数 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int value = in.nextInt();
        int res = 0;
        for (int i = 0; i <= value; i++) {
            if(isVailte(i)){
                res++;
            }
        }
        System.out.println(res);
    }

    private static boolean isVailte(int value) {
        int square = value*value;
        String valueString = String.valueOf(value);
        String squareString = String.valueOf(square);
        int length1 = valueString.length();
        int length2 = squareString.length();
        return valueString.equals(squareString.substring(length2-length1,length2));
    }
}
