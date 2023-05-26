package 剑指offer100;

/**
 * @Author shizq18
 * @Date 2023/5/10
 * @Description
 */
class Test {
    public static void main(String[] args) {
        二叉树的最近公共祖先 test = new 二叉树的最近公共祖先();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        System.out.println(test.lowestCommonAncestor(root, new TreeNode(3), new TreeNode(2)).val);
    }

}
public class 二叉树的最近公共祖先 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root.val == p.val || root.val == q.val){
            return root;
        }
        // 判断节点是否在两边
        if ((hasThisTreeNode(root.left, p) && hasThisTreeNode(root.right, q)) || (hasThisTreeNode(root.left, q) && hasThisTreeNode(root.right, p))) {
            return root;
        } else if ((hasThisTreeNode(root.left, p) && hasThisTreeNode(root.left, q))) {
            return lowestCommonAncestor(root.left, p, q);
        } else if ((hasThisTreeNode(root.right, p) && hasThisTreeNode(root.right, q))) {
            return lowestCommonAncestor(root.right, p, q);
        }
        return null;
    }

    /**
     * 判断该节点下面是否包含此节点
     */
    private boolean hasThisTreeNode(TreeNode root, TreeNode p) {
        if (root == null){
            return false;
        }
        if (root.val == p.val) {
            return true;
        }
        return hasThisTreeNode(root.left, p) ||
        hasThisTreeNode(root.right, p);
    }
}
