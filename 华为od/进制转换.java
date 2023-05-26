package 华为od;

import java.util.*;

/**
 * @Author shizq18
 * @Date 2023/5/24
 * @Description
 */
public class 进制转换 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextLine()) { // 注意 while 处理多个 case
            String string = in.nextLine();
            int length = string.length();
            int res = 0;
            for(int i=2;i<length;i++) {
                int num = 0;
                char current = string.charAt(i);
                if(current > '0' && current <= '9') {
                    num = current - '0';
                }else if(current >= 'a' && current <= 'f') {
                    num = current - 'a' + 10;
                }else if(current >= 'A' && current <= 'F') {
                    num = current - 'A' + 10;
                }
                res += num*Math.pow(16,length-i-1);
            }
            System.out.println(res);
        }
    }
}
