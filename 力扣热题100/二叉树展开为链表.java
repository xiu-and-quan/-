package 力扣热题100;

import 二叉树.TreeNode;

/**
 * @Author shizq18
 * @Date 2023/9/5
 * @Description
 */
public class 二叉树展开为链表 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(5);
        root.right.right = new TreeNode(6);
        flatten(root);
    }
    public static void flatten(TreeNode root) {
        // 前序遍历
        if (root == null) {
            return;
        }
        flatten(root.left);
        flatten(root.right);
        TreeNode right = root.right;
        TreeNode left = root.left;
        if (left != null) {
            root.right = left;
            while (left.right!= null) {
                left = left.right;
            }
            left.right = right;
        }
        root.left = null;
    }
}
