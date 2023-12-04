package 力扣热题100;

import java.util.PriorityQueue;

/**
 * @Author shizq18
 * @Date 2023/10/26
 * @Description
 */
public class 寻找两个正序数组的中位数 {
    public static void main(String[] args) {
//        double res = findMedianSortedArrays(new int[]{1,3},new int[]{2});
//        System.out.println(res);
    }
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length == 0 && nums2.length == 0) {
            return 0;
        }
        // 小顶堆
        PriorityQueue<Integer> smallQueue = new PriorityQueue<>();
        // 大顶堆
        PriorityQueue<Integer> bigQueue = new PriorityQueue<>((x,y)->y-x);
        int whichOne = 0;
        for (int i = 0; i < nums1.length; i++) {
            addQueue(i,whichOne,nums1,smallQueue,bigQueue);
        }
        for (int i = 0; i < nums2.length; i++) {
            addQueue(i,whichOne,nums2,smallQueue,bigQueue);
        }
        if (smallQueue.size() == bigQueue.size()) {
            return ((double)smallQueue.poll()+(double)bigQueue.poll())/2;
        } else if (smallQueue.size() < bigQueue.size()) {
            return (double)bigQueue.poll();
        } else {
            return (double)smallQueue.poll();
        }
    }

    private void addQueue(int i, int whichOne, int[] nums, PriorityQueue<Integer> smallQueue, PriorityQueue<Integer> bigQueue){
        if (whichOne == 0) {
            smallQueue.add(nums[i]);
            whichOne++;
        } else {
            bigQueue.add(nums[i]);
            whichOne--;
        }
        if (!smallQueue.isEmpty() && !bigQueue.isEmpty()) {
            bigQueue.add(smallQueue.poll());
            smallQueue.add(bigQueue.poll());
        }
    }
}
