package 华为od;

import java.util.Scanner;

/**
 * @Author shizq18
 * @Date 2023/5/25
 * @Description
 */
public class 质数因子 {
    /*public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        int num = in.nextInt();
        int x = num;
        int y = 2;
        StringBuilder sb = new StringBuilder("");
        while(x>1){
            if(x%y==0){
                x=x/y;
                sb.append(y+" ");
            }else{
                // 不超时的关键代码
                if(y>x/y){
                    y = x;
                }
                else {
                    y++;
                }
            }
        }
        System.out.println(sb.toString());
    }*/
    public static void main(String[] args) {
        solve(180);
    }

    public static void solve(int num) {
        for (long i = 2; i <= num; ++i) {
            while (num % i == 0) {
                System.out.print(i + " ");
                num /= i;
            }
        }
        System.out.println();
    }
}
