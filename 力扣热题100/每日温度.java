package 力扣热题100;

import java.util.Stack;

/**
 * @Author shizq18
 * @Date 2023/11/13
 * @Description
 */
public class 每日温度 {
    /*给定一个整数数组 temperatures ，表示每天的温度，返回一个数组 answer ，其中 answer[i]
    是指对于第 i 天，下一个更高温度出现在几天后。如果气温在这之后都不会升高，请在该位置用 0 来代替。
    示例 1:

    输入: temperatures = [73,74,75,71,69,72,76,73]
    输出: [1,1,4,2,1,1,0,0]
    示例 2:

    输入: temperatures = [30,40,50,60]
    输出: [1,1,1,0]
    示例 3:

    输入: temperatures = [30,60,90]
    输出: [1,1,0]*/
    public static void main(String[] args) {
        int[] resList = dailyTemperatures(new int[]{89,62,70,58,47,47,46,76,100,70});
        // [8,1,5,4,1,2,1,1,0,0]
        // [8,1,5,4,3,2,1,1,0,0]
        System.out.println("success");
    }
    public static int[] dailyTemperatures(int[] temperatures) {
        int len = temperatures.length;
        // 单调栈
        Stack<int[]> stack = new Stack<>();
        int[] resList = new int[len];
        for (int i = len-1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek()[1] <= temperatures[i]) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                resList[i] = stack.peek()[0]-i;
            }
            stack.add(new int[]{i, temperatures[i]});
        }
        return resList;
    }
}
