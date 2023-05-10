package 剑指offer100;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @Author shizq18
 * @Date 2023/5/4
 * @Description
 */
public class 滑动窗口的最大值 {
    public static void main(String[] args) {
        int[] res = maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3);
        System.out.println(Arrays.toString(res));
    }
    public static int[] maxSlidingWindow(int[] nums, int k) {
        int length = nums.length;
        int[] maxValueInWindow = new int[length - k + 1];
        int startIndex = 0;
        // 优先级队列
        OrderQueue orderQueue = new OrderQueue();
        for (int i = 0; i < length; i++) {
            if (i < k) {
                orderQueue.put(nums[i]);
            }
            if (i == k -1){
                maxValueInWindow[startIndex++] = orderQueue.getMaxValue();
                continue;
            }
            if (i >= k){
                orderQueue.put(nums[i]);
                if (orderQueue.getMaxValue() == nums[i - k]){
                    orderQueue.delete();
                }
                maxValueInWindow[startIndex++] = orderQueue.getMaxValue();
            }
        }
        return maxValueInWindow;
    }
}

/**
 * 降序类
 */
class OrderQueue {
    // 双链表构造
    LinkedList<Integer> list = new LinkedList<>();

    /** 添加操作 */
    public void put(int num){
        while (!list.isEmpty() && list.getLast() < num){
            list.removeLast();
        }
        list.add(num);
    }
    /** 删除操作 */
    public void delete(){
        list.removeFirst();
    }

    /**
     * 获取最大值
     */
    public int getMaxValue(){
        return list.getFirst();
    }
}
