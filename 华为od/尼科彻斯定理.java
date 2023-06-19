package 华为od;

import java.util.Map;
import java.util.Scanner;

/**
 * @Author shizq18
 * @Date 2023/6/9
 * @Description
 */
public class 尼科彻斯定理 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int num = in.nextInt();
            int firstElement = (int) (Math.pow(num,2) - (num-1));
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < num; i++) {
                stringBuilder.append(firstElement);
                firstElement += 2;
                if (i != num-1){
                    stringBuilder.append("+");
                }
            }
            System.out.println(stringBuilder.toString());
        }
    }
}