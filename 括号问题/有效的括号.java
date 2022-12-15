package 括号问题;

import java.util.Stack;

public class 有效的括号 {
    public static void main(String[] args) {
        String s = "]";
        System.out.println(isValid(s));
    }
    public static boolean isValid(String s) {
        //用栈
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(c =='{' || c == '[' || c == '('){
                stack.push(c);
            }else{
                if (stack.isEmpty()){
                    return false;
                }
                char topItem = stack.peek();
                if(match(topItem,c)){
                    stack.pop();
                }else{
                    return false;
                }
            }
        }
        return stack.isEmpty();
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
