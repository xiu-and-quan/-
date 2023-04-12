package 剑指offer100;

import java.util.Stack;

public class 栈的压入弹出序列 {
    public static void main(String[] args) {
        System.out.println(validateStackSequences(new int[]{0,1},new int[]{0,1}));
    }
    public static boolean validateStackSequences(int[] pushed, int[] popped) {
            Stack<Integer> stack = new Stack<>();
            int i = 0;
            for(int num : pushed) {
                stack.push(num); // num 入栈
                while(!stack.isEmpty() && stack.peek() == popped[i]) { // 循环判断与出栈
                    stack.pop();
                    i++;
                }
            }
            return stack.isEmpty();
        }
        /*if (pushed.length == 0){
            return true;
        }
        Stack<Integer> stack = new Stack<>();
        int pushedLength = pushed.length;
        int poppedLength = popped.length;
        int index = 0;
        for (int i = 0; i < pushedLength; i++) {
            if (pushed[i] == popped[0]){
                index = i;
                break;
            }
        }
        for (int i = 0; i <= index; i++) {
            stack.push(pushed[i]);
        }
        int right = 0;
        while (right < poppedLength){
            if (index >= pushedLength){
                return false;
            }

            if (!stack.isEmpty() && stack.peek() == popped[right]){
                right++;
                stack.pop();
            }
            if (!stack.isEmpty() && stack.peek() != popped[right]) {
                index++;
                if (index < pushedLength) {
                    stack.push(pushed[index]);
                }else {
                    return false;
                }
            }
            if (right == poppedLength){
                return true;
            }
            if (stack.isEmpty()){
                index++;
                stack.push(pushed[index]);
            }
        }
        return true;
    }*/
}
