package 单调栈;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class 下一个更大元素简单 {
    public static void main(String[] args) {
        int[] testList = new int[]{3,2,4,5};
        int[] resList = nextGreaterElement(testList,testList);
        System.out.println(Arrays.toString(resList));
    }
    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        //逆序放
        int[] res = new int[nums2.length-1];
        int index = nums2.length-3;
        res[index+1] = -1;
        Stack<Integer> monotonousStack = new Stack<>();
        for (int i = nums2.length-1; i > 0; i--) {
            if (monotonousStack.isEmpty()) {
                monotonousStack.add(nums2[i]);
            }else {
                while (monotonousStack.peek() <= nums2[i]){
                    monotonousStack.pop();
                }
                res[index] = monotonousStack.peek();
                index--;
                monotonousStack.add(nums2[i]);
            }
        }
        return res;
    }
}
