package 剑指offer100;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @Author shizq18
 * @Date 2023/5/4
 * @Description
 */
public class 队列的最大值 {
    public static void main(String[] args) {
        MaxQueue maxQueue = new MaxQueue();
        System.out.println(maxQueue.max_value());
        maxQueue.pop_front();
        System.out.println(maxQueue.max_value());
        maxQueue.push_back(46);
        System.out.println(maxQueue.max_value());
        maxQueue.pop_front();
        System.out.println(maxQueue.max_value());
        maxQueue.pop_front();
        maxQueue.push_back(868);
    }
}
class MaxQueue {
    Queue<Integer> queue = new LinkedList<>();
    Queue<Integer> queueMaxValue = new LinkedList<>();
    public MaxQueue() {
    }

    public int max_value() {
        if (queueMaxValue.isEmpty()){
            return -1;
        }
        return queueMaxValue.peek();
    }
    public void push_back(int value) {
        queue.add(value);
        if (queueMaxValue.isEmpty()){
            queueMaxValue.add(value);
        }else {
            while (queueMaxValue.peek() < value){
                queueMaxValue.poll();
            }
            queueMaxValue.add(value);
        }
    }

    public int pop_front() {
        if (queue.isEmpty()){
            return -1;
        }
        if (queueMaxValue.peek().equals(queue.peek())){
            queueMaxValue.poll();
        }
        return queue.poll();
    }
}
