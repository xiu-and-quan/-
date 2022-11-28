package 原地修改数组;

public class 移除元素 {
    public static void main(String[] args) {
        int[] nums = new int[]{3,2,2,3};
        int res = removeElement(nums,3);
        System.out.println(res);
    }
    public static int removeElement(int[] nums, int val) {
        int left=0, right=0;
        while(right<nums.length){
            if (nums[right]!=val){
                nums[left]=nums[right];
                left++;
            }
            right++;
        }
        return left;
    }
}
