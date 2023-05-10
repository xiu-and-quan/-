package 剑指offer100;

/**
 * @Author shizq18
 * @Date 2023/5/8
 * @Description
 */
public class 圆圈中最后剩下的数字 {
    public static void main(String[] args) {
        System.out.println(lastRemaining(5,1));
    }
     public static int lastRemaining(int n, int m) {
        int lastLeftNum = 0;
         for (int i = 2; i <= n; i++) {
             lastLeftNum = (lastLeftNum + m) % i;
         }
         return lastLeftNum;
    }
}


