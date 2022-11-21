package 田忌赛马;

import javax.swing.*;
import java.util.*;

public class 优势洗牌 {
    public static void main(String[] args) {
        int[] res = advantageCount(new int[]{2,0,4,1,2},new int[]{1,3,0,0,2});
        System.out.println(Arrays.toString(res));
    }
    /*给定两个大小相等的数组 nums1 和 nums2，nums1 相对于 nums2 的优势可以用满足
     nums1[i] > nums2[i] 的索引 i 的数目来描述。返回 nums1 的任意排列，使其相对
     于 nums2 的优势最大化。*/
    public static int[] advantageCount(int[] nums1, int[] nums2) {
        int[] res = new int[nums2.length];
        Queue<int[]> queue = new PriorityQueue<>((o1, o2) -> o2[0] - o1[0]);
        Arrays.sort(nums1);
        for(int i=0;i<nums2.length;i++){
            queue.add(new int[]{nums2[i],i});
        }
        int left = 0, right = nums1.length-1;
        while (!queue.isEmpty()){

            int[] array =  queue.poll();
            int value = array[0];
            int index = array[1];
            if (value >= nums1[right]){
                res[index] = nums1[left];
                left++;
            }else {
                res[index] = nums1[right];
                right--;
            }
        }
        return res;
    }
}
