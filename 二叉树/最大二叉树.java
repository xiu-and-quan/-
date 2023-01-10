package 二叉树;

public class 最大二叉树 {
    public static void main(String[] args) {
        int[] nums = new int[]{3,2,1,6,0,5};
        constructMaximumBinaryTree(nums);
    }
    public static TreeNode constructMaximumBinaryTree(int[] nums) {
        return helper(nums,0,nums.length-1);
    }

    private static TreeNode helper(int[] nums, int left, int right) {
        //递归结束条件
        if (left > right){
            return null;
        }
        int max = Integer.MIN_VALUE;
        int maxIndex = left;
        for(int i=left;i<=right;i++){
            if(nums[i]>max){
                maxIndex = i;
                max = nums[i];
            }
        }
        TreeNode root = new TreeNode(nums[maxIndex]);
        root.left = helper(nums,left,maxIndex-1);
        root.right = helper(nums,maxIndex+1,right);
        return root;
    }
}
