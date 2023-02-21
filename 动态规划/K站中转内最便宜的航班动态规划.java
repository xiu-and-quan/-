package 动态规划;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class K站中转内最便宜的航班动态规划 {
    public static void main(String[] args) {
        System.out.println(findCheapestPrice(3,new int[][]{{0,1,100},{1,2,100},{0,2,500}},0,2,0));;
    }
    static HashMap<Integer, ArrayList<int[]>> dstToValue = new HashMap<>();
    public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        for (int[] element:
                flights) {
            dstToValue.putIfAbsent(element[1],new ArrayList<int[]>());
            dstToValue.get(element[1]).add(element);
        }
        //加备忘录
        int[][] memo = new int[n][k+2];
        for (int i = 0; i < memo.length; i++) {
            Arrays.fill(memo[i],-2);
        }
        return helperFunction(src,dst,k,memo);
    }

    private static int helperFunction(int src, int dst, int k, int[][] memo) {
        //base case
        if (dst == src){
            return memo[dst][k+1] = 0;
        }
        if (k < 0){
            return memo[dst][k+1] = -1;
        }
        //分解问题 受前面所有的可能性影响，类似自由之路，需要考虑所有的
        if (memo[dst][k+1] != -2){
            return memo[dst][k+1];
        }
        int minDistance = Integer.MAX_VALUE;
        if (dstToValue.containsKey(dst)) {
            for (int[] element :
                    dstToValue.get(dst)) {
                int isAvaliable = helperFunction(src, element[0], k - 1, memo);
                if (isAvaliable == -1) {
                    continue;
                } else {
                    minDistance = Math.min(isAvaliable + element[2], minDistance);
                }
            }
        }
        return memo[dst][k+1] = minDistance == Integer.MAX_VALUE ? -1 : minDistance;
    }
}
