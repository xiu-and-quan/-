package 力扣热题100;

import java.util.*;

/**
 * @Author shizq18
 * @Date 2023/7/31
 * @Description
 */
public class 无重复字符的最长字串 {
    public static void main(String[] args) {
        System.out.println(solve(""));
    }

    public static int solve(String s) {
        Set<Character> repeatSet = new HashSet<>();
        Queue<Character> queue = new LinkedList<>();
        int length = s.length();
        int resCount = 0;
        for (int i = 0; i < length; i++) {
            char currentElement = s.charAt(i);
            if (repeatSet.add(currentElement)){
                queue.add(currentElement);
            } else {
                resCount = Math.max(resCount, queue.size());
                while (!queue.isEmpty() && queue.peek() != currentElement) {
                    char removeElelment = queue.poll();
                    repeatSet.remove(removeElelment);
                }
                queue.poll();
                queue.add(currentElement);
            }
        }
        return Math.max(resCount, queue.size());
    }
}
