package 力扣热题100;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author shizq18
 * @Date 2023/8/2
 * @Description
 */
public class 最小覆盖子串 {
    public static String minWindow(String s, String t) {
        int lengthS = s.length(),
            lengthT = t.length();
        Map<Character, Integer> movingWindow = new HashMap<>();
        Map<Character, Integer> needdWindow = new HashMap<>();
        for (int i = 0; i < lengthT; i++) {
            char element = t.charAt(i);
            int elementCount = needdWindow.getOrDefault(t.charAt(i),0);
            needdWindow.put(element, elementCount+1);
        }
        int size = needdWindow.size();

        int left = 0, right = 0 , count = 0, minLength = Integer.MAX_VALUE, start = 0, end = 0;
        while (right < lengthS) {
            char currentRightElement = s.charAt(right);
            if (needdWindow.containsKey(currentRightElement)) {
                int oldCount = movingWindow.getOrDefault(currentRightElement, 0);
                movingWindow.put(currentRightElement, oldCount+1);
                if (movingWindow.get(currentRightElement).equals(needdWindow.get(currentRightElement))) {
                    count++;
                }
            }
            right++;
            while (count == size) {
                if (right-left < minLength) {
                    minLength = right - left;
                    start = left;
                    end = right;
                }
                // 收缩
                char currentLeftElement = s.charAt(left);
                if (needdWindow.containsKey(currentLeftElement)) {
                    if (needdWindow.get(currentLeftElement).equals(movingWindow.get(currentLeftElement))) {
                        count--;
                    }
                    movingWindow.put(currentLeftElement,movingWindow.get(currentLeftElement)-1);
                }
                left++;
            }
        }
        return s.substring(start,end);
    }
}
