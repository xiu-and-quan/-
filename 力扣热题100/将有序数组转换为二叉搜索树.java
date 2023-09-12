package 力扣热题100;

import 二叉树.TreeNode;

/**
 * @Author shizq18
 * @Date 2023/8/31
 * @Description
 */
public class 将有序数组转换为二叉搜索树 {
    public static void main(String[] args) {
        TreeNode resTree = sortedArrayToBST(new int[]{-10, -3, 0, 5, 9});
        System.out.println("success");
    }
    public static TreeNode sortedArrayToBST(int[] nums) {
        int length = nums.length;
        return sortedArrayToBST(nums, 0, length-1);
    }

    private static TreeNode sortedArrayToBST(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        int middle = (start + end) / 2;
        TreeNode root = new TreeNode(nums[middle]);
        TreeNode left = sortedArrayToBST(nums, start, middle-1);
        TreeNode right = sortedArrayToBST(nums, middle+1, end);
        root.left = left;
        root.right = right;
        return root;
    }
}
