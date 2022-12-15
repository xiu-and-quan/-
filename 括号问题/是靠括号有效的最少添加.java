package 括号问题;

import java.util.Stack;

public class 是靠括号有效的最少添加 {
    public static void main(String[] args) {
        String s = "(((";
        System.out.println(minAddToMakeValid(s));
    }
    public static int minAddToMakeValid(String s) {
        //还是用栈
        Stack<Character> stack = new Stack<>();
        int count = 0;
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(c =='{' || c == '[' || c == '('){
                stack.push(c);
            }else{
                if(stack.isEmpty()){
                    count++;
                }else{
                    char topItem = stack.peek();
                    if(match(topItem,c)){
                        stack.pop();
                    }else{
                        count++;
                    }
                }
            }
        }
        return stack.size() + count;
    }
    public static boolean match(char c1,char c2){
        if(c1 == '{' && c2 == '}'){
            return true;
        }
        if(c1 == '[' && c2 == ']'){
            return true;
        }
        if(c1 == '(' && c2 == ')'){
            return true;
        }
        return false;
    }
}
