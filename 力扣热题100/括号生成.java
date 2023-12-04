package 力扣热题100;

import java.util.*;

/**
 * @Author shizq18
 * @Date 2023/10/8
 * @Description
 */
public class 括号生成 {
    public static void main(String[] args) {
        generateParenthesis(3);
        System.out.println("success");
    }
    static List<String> pathList = new ArrayList<>();
    public static List<String> generateParenthesis(int n) {
        int left = n, right = n;
        StringBuilder path = new StringBuilder();
        traver(left, right, path);
        return pathList;
    }

    private static void traver(int left, int right, StringBuilder path) {
        if (left == 0 && right == 0) {
            pathList.add(path.toString());
        }
        if (right < left) {
            return;
        }
        // 做选择 左边和右边
        if (left > 0) {
            path.append('(');
            left -= 1;
            traver(left, right, path);
            left += 1;
            path.deleteCharAt(path.length() - 1);
        }
        if (right > 0) {
            path.append(')');
            right -= 1;
            traver(left, right, path);
            right += 1;
            path.deleteCharAt(path.length() - 1);
        }
    }
    /*public static void main(String[] args) {
        generateParenthesis(2);
    }
    static Set<String> pathList = new HashSet<>();
    public static List<String> generateParenthesis(int n) {
        char[] chars = new char[2*n];
        for (int i = 0; i < 2*n; i++) {
            if (i < n) {
                chars[i] = '(';
            } else {
                chars[i] = ')';
            }
        }
        StringBuilder path = new StringBuilder();
        boolean[] isVisited = new boolean[2*n];
        traver(chars,path,isVisited);
        List<String> resList = new ArrayList<>();
        for (String s:
             pathList) {
            char[] list = s.toCharArray();
            if(isValied(list)){
                resList.add(s);
            }
        }
        return resList;
    }

    *//**
     * 括号是否合法
     *//*
    private static boolean isValied(char[] list) {
        Queue<Character> queue = new LinkedList<>();
        for (int i = 0; i < list.length; i++) {
            if (list[i] == '(') {
                queue.add(list[i]);
            }
            if (!queue.isEmpty() && queue.peek() == '(' && list[i] == ')') {
                queue.poll();
            }
        }
        return queue.isEmpty();
    }

    private static void traver(char[] chars, StringBuilder path, boolean[] isVisited) {
        if (path.length() == chars.length) {
            pathList.add(path.toString());
        }
        for (int i = 0; i < chars.length; i++) {
            if (isVisited[i]) {
                continue;
            }
            path.append(chars[i]);
            isVisited[i] = true;
            traver(chars,path,isVisited);
            path.deleteCharAt(path.length()-1);
            isVisited[i] = false;
        }
    }
*/
}