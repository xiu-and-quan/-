package 华为od;

import java.util.*;

/**
 * @Author shizq18
 * @Date 2023/5/26
 * @Description
 */
public class 购物单 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int m = sc.nextInt();

        Goods[] goods = new Goods[m+1];
        for(int i = 0; i <= m; i++){
            goods[i] = new Goods();
        }
        for(int i = 1; i <= m; i++){
            int v = sc.nextInt();
            int p = sc.nextInt();
            int q = sc.nextInt();
            goods[i].v = v;
            goods[i].p = p;
            goods[i].q = q;
            if(q > 0){
                if(goods[q].a1 == -1){
                    goods[q].a1 = i;
                }else{
                    goods[q].a2 = i;
                }
            }
        }

        int[][] dp = new int[m+1][N+1];
        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= N; j++){
                dp[i][j] = dp[i-1][j];
                if(goods[i].q!=0){
                    continue;
                }
                // 比主件价值多
                if(j>=goods[i].v){
                    dp[i][j] = Math.max(dp[i][j], dp[i-1][j-goods[i].v] + goods[i].p*goods[i].v);
                }
                if(goods[i].a1 != -1 && j >= goods[i].v + goods[goods[i].a1].v){
                    dp[i][j] = Math.max(dp[i][j], dp[i-1][j-goods[i].v - goods[goods[i].a1].v] + goods[i].p*goods[i].v + goods[goods[i].a1].p*goods[goods[i].a1].v);
                }
                if(goods[i].a2 != -1 && j >= goods[i].v + goods[goods[i].a2].v){
                    dp[i][j] = Math.max(dp[i][j], dp[i-1][j-goods[i].v - goods[goods[i].a2].v] + goods[i].p*goods[i].v + goods[goods[i].a2].p*goods[goods[i].a2].v);
                }
                if(goods[i].a1 != -1 && goods[i].a2 != -1 &&  j >= goods[i].v + goods[goods[i].a1].v + goods[goods[i].a2].v){
                    dp[i][j] = Math.max(dp[i][j], dp[i-1][j-goods[i].v - goods[goods[i].a1].v - goods[goods[i].a2].v] + goods[i].p*goods[i].v + goods[goods[i].a1].p*goods[goods[i].a1].v + goods[goods[i].a2].p*goods[goods[i].a2].v);
                }
            }
        }
        System.out.println(dp[m][N]);
    }
}

class Goods {
    int v;
    int p;
    int q;

    int a1 = -1;  //定义附件1的编号
    int a2 = -1;  //定义附件2的编号
}

