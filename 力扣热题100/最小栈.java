package 力扣热题100;

import java.util.Stack;

/**
 * @Author shizq18
 * @Date 2023/10/30
 * @Description
 */
public class 最小栈 {
}

/**
 * 实现 MinStack 类:
 *
 * MinStack() 初始化堆栈对象。
 * void push(int val) 将元素val推入堆栈。
 * void pop() 删除堆栈顶部的元素。
 * int top() 获取堆栈顶部的元素。
 * int getMin() 获取堆栈中的最小元素。
 * ["MinStack","push","push","push","getMin","top","pop","getMin"]
 * [[],[-2],[0],[-1],[],[],[],[]]
 */
class MinStack {
    /**
     * 两个栈
     */
    Stack<Integer> stack1;
    Stack<Integer> stack2;
    public MinStack() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void push(int val) {
        stack1.push(val);
        if (stack2.size() > 1) {
            if (val > stack2.pop()) {
                stack2.push(stack2.peek());
            } else {
                stack2.push(val);
            }
        } else {
            stack2.push(val);
        }
    }

    public void pop() {
        stack1.pop();
        stack2.pop();
    }

    public int top() {
        return stack1.peek();
    }

    public int getMin() {
        return stack2.peek();
    }
}