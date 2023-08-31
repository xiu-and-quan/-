package 力扣热题100;

import 二叉树.TreeNode;

/**
 * @Author shizq18
 * @Date 2023/8/31
 * @Description
 */
public class 对称二叉树 {
    public boolean isSymmetric(TreeNode root) {
        return isSymmetric(root.left,root.right);
    }

    // 判断两棵树
    private boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left != null && right != null) {
            return isSymmetric(left.left, right.right)
                    && isSymmetric(left.right, right.left)
                    && (left.val == right.val);
        } else {
            return false;
        }
    }
}

