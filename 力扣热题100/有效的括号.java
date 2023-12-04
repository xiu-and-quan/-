package 力扣热题100;

import java.util.*;

/**
 * @Author shizq18
 * @Date 2023/10/30
 * @Description
 */
public class 有效的括号 {
    public static void main(String[] args) {
        System.out.println(isValid("([)]"));
    }
    public static boolean isValid(String s) {
        Map<Character,Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
        Stack<Character> queue = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (!queue.isEmpty() && map.containsKey(s.charAt(i))) {
                if (queue.peek() == map.get(s.charAt(i))) {
                    queue.pop();
                    continue;
                }
            }
            queue.add(s.charAt(i));
        }
        return queue.isEmpty();
    }
}
