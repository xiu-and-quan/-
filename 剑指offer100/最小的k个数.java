package 剑指offer100;

import java.util.PriorityQueue;

public class 最小的k个数 {
    public int[] getLeastNumbers(int[] arr, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int i = 0; i < arr.length; i++){
            queue.add(arr[i]);
        }
        int[] res = new int[k];
        for(int i = 0; i < k; i++){
            res[i]  = queue.poll();
        }
        return res;
    }
}

