package 力扣热题100;

import 二叉树.TreeNode;

/**
 * @Author shizq18
 * @Date 2023/8/31
 * @Description
 */
public class 二叉树的直径 {
    int res = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        depth(root);
        return res;
    }

    private int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = depth(root.left);
        int right = depth(root.right);
        res = Math.max(res,depth(root.left)+depth(root.right));
        return Math.max(left,right)+1;
    }
}
