package 力扣热题100;

import 二叉树.TreeNode;

/**
 * @Author shizq18
 * @Date 2023/8/30
 * @Description
 */
public class 翻转二叉树 {
    public TreeNode invertTree(TreeNode root) {
         if (root == null) {
             return null;
         }
         TreeNode left = invertTree(root.left);
         TreeNode right = invertTree(root.right);
         root.left = right;
         root.right = left;
         return root;
    }
}
