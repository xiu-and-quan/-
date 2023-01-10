package 单调栈;

import java.util.LinkedList;
import java.util.Stack;

public class 去除重复字母 {
    public static void main(String[] args) {
        String s = removeDxiaoDingDuilicateLetters("cbacdcbc");
        System.out.println(s);
    }
    public static String removeDxiaoDingDuilicateLetters(String s) {
        int[] countList = new int[256];
        for (int i = 0; i < s.length(); i++) {
            countList[s.charAt(i)]++;
        }
        //需要按照字典排序
        int[] charArray = new int[256];
        //单调栈
        Stack<Character> stack = new Stack<>();
        boolean[] isExist = new boolean[256];
        for(int i = 0;i < s.length();i++){
            char curr = s.charAt(i);
            countList[curr]--;
            if (isExist[curr]){
                continue;
            }
            stack.push(curr);
            isExist[curr] = true;
            while (stack.peek() > curr && !stack.isEmpty()){
                if(countList[stack.peek()] == 0){
                    break;
                }
                isExist[stack.peek()]=false;
                stack.pop();
            }
        }
        StringBuilder res = new StringBuilder();
        while (!stack.isEmpty()){
            res.append(stack.pop());
        }
        return res.reverse().toString();
    }
}
