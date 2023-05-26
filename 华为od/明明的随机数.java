package 华为od;

import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @Author shizq18
 * @Date 2023/5/24
 * @Description
 */
public class 明明的随机数 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            // 生成数的个数
            int length = in.nextInt();
            int[] array = new int[length];
            int index = 0;
            for (int i = 0; i < length; i++) {
                array[i] = in.nextInt();
            }
            solve(array);
        }

    }
    public static void solve(int[] array) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (int i = 0; i < array.length; i++) {
            priorityQueue.add(array[i]);
        }
        int preValue =priorityQueue.peek();
        System.out.println(preValue);
        while (!priorityQueue.isEmpty()) {
            int current = priorityQueue.poll();
            if (current != preValue){
                System.out.println(current);
                preValue = current;
            }
        }
    }
}
