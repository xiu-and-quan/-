package amazon;

import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Stack;

public class KthSmallestElement {
    public static int kthSmallest(int[] arr, int l, int r, int k)
    {
        //Your code here
        Arrays.sort(arr);
        return arr[k-1];
    }
}
