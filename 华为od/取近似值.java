package 华为od;

import java.util.Scanner;

/**
 * @Author shizq18
 * @Date 2023/5/25
 * @Description
 */
public class 取近似值 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextFloat()) { // 注意 while 处理多个 case
            float num = in.nextFloat();
            int numInt = (int)num;
            if(num - (float)numInt >= 0.5){
                System.out.print(numInt + 1);
            }else{
                System.out.print(numInt);
            }
        }
    }
}
