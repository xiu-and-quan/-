package 动态规划;

import java.util.ArrayList;
import java.util.HashMap;

public class 自由之路dp {
    public static void main(String[] args) {
        System.out.println( findRotateSteps("goding","gd"));
    }
    static HashMap<Character, ArrayList<Integer>> charToIndex = new HashMap<>();
    public static int findRotateSteps(String ring, String key) {
        char[] ringIndex = ring.toCharArray();
        for (int i = 0; i < ringIndex.length; i++) {
            charToIndex.putIfAbsent(ringIndex[i],new ArrayList<>());
            charToIndex.get(ringIndex[i]).add(i);
        }
        int ringLength = ring.length();
        int keyLength = key.length();
        int[][] dp = new int[key.length()][ringLength];
        //base case
        for (int index:
                charToIndex.get(key.charAt(0))){
                int minDistance = Math.min(index,ringLength-index);
                dp[0][index] = minDistance+1;
        }
        //遍历状态
        for (int i = 1; i < key.length(); i++) {
            for (int index:
                 charToIndex.get(key.charAt(i))) {
                int minStep = Integer.MAX_VALUE;
                for (int preIndex:
                        charToIndex.get(key.charAt(i-1))) {
                    int distance = Math.abs(index - preIndex);
                    int minDistance = Math.min(distance,ringLength-distance);
                    minStep = Math.min(minStep,minDistance+1+dp[i-1][preIndex]);
                }
                dp[i][index] = minStep;
            }
        }
        int resStep = Integer.MAX_VALUE;
        for (int index:
             charToIndex.get(key.charAt(keyLength-1))) {
             resStep = Math.min(resStep,dp[keyLength-1][index]);
        }
        return resStep;
    }
}
