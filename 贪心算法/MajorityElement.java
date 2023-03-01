package 贪心算法;

import java.util.Arrays;

public class MajorityElement {
    public static void main(String[] args) {
        System.out.println(majorityElement(new int[]{3,2,3}));
    }
    static int majorityElement(int nums[])
    {
        // your code here
        Arrays.sort(nums);
        int size = nums.length;
        int left = 0;
        int right = 0;
        int res = nums[0];
        int count = 0;
        while(right < size){
            if (nums[right] != nums[left] | right == size-1){
                if ( count <= right -1 -left){
                    count = right -1 -left;
                    res= nums[left];
                    left = right;
                }
            }
            right++;
        }
        return res;
    }
}
