package 力扣热题100;

import 二叉树.TreeNode;

/**
 * @Author shizq18
 * @Date 2023/9/12
 * @Description
 */
public class 二叉树的最近公共祖先 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root.val == p.val || root.val == q.val) {
            return root;
        }
        if (hasNode(root.left,p) && (hasNode(root.right,q)) || hasNode(root.left,q) && (hasNode(root.right,p))) {
            return root;
        } else if (hasNode(root.left,p) && (hasNode(root.left,q))) {
            return lowestCommonAncestor(root.left,p,q);
        } else if (hasNode(root.right,p) && (hasNode(root.right,q))){
            return lowestCommonAncestor(root.right,p,q);
        }
        return null;
    }

    private boolean hasNode(TreeNode root, TreeNode node) {
        if (root.val == node.val) {
            return true;
        }
        if (root == null) {
            return false;
        }
        return hasNode(root.left,node) || hasNode(root.right,node);
    }

    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        if (root == p || root == q || root == null) {
            return root;
        }
        TreeNode left = lowestCommonAncestor1(root.left,p,q);
        TreeNode right = lowestCommonAncestor1(root.right,p,q);
        if (left == null) {
            return right;
        } else {
            return left;
        }
    }
}
