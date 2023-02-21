package 动态规划;

import java.util.ArrayList;
import java.util.HashMap;

public class 自由之路 {
    public static void main(String[] args) {
        String ring = "godding";

    }
    public static int findRotateSteps(String ring, String key) {
        char[] ringIndex = ring.toCharArray();
        for (int i = 0; i < ringIndex.length; i++) {
            charToIndex.putIfAbsent(ringIndex[i],new ArrayList<>());
            charToIndex.get(ringIndex[i]).add(i);
        }
        //确定12点方向的字母是哪个
        return helperFunction(ring,0,key,0);
    }
    static HashMap<Character, ArrayList<Integer>> charToIndex = new HashMap<>();

    private static int helperFunction(String ring, int i, String key, int j) {
        //结束条件
        if (i == ring.length()){
            return 0;
        }
        int minStep = Integer.MAX_VALUE;
        for (int index:charToIndex.get(j)
             ) {
            //左转和右转
            int distance = Math.abs(index - i);
            //选择电当前字母的左转右转
            int minDistance = Math.min(distance,ring.length()-distance);
            //再考虑前一步结果
            minStep = Math.min(minStep,minDistance + 1 + helperFunction(ring,index,key,j+1));
        }
        return 0;
    }

}
