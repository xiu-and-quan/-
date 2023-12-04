package 力扣热题100;

import 二叉树.TreeNode;

/**
 * @Author shizq18
 * @Date 2023/9/12
 * @Description
 */
public class 二叉搜索树的最近公共祖先 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode leftParent = lowestCommonAncestor(root.left,p,q);
        TreeNode rightParent = lowestCommonAncestor(root.right,p,q);
        if (leftParent == null) {
            return rightParent;
        } else if (leftParent == null) {
            return rightParent;
        }
        return root;
    }
}
