package 剑指offer100;

/**
 * @Author shizq18
 * @Date 2023/5/10
 * @Description
 */
public class 二叉搜索树的最近公共祖先 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        System.out.println(lowestCommonAncestor(root, new TreeNode(3), new TreeNode(1)).val);
    }
    static TreeNode resNode;
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 二叉搜索树中序遍历是升序
        getCommonParentNode(root, p , q);
        return resNode;
    }
    public static void getCommonParentNode(TreeNode root, TreeNode p, TreeNode q){
        if (root == null) {
            return;
        }
        if (root.val == p.val || root.val == q.val || (root.val > p.val && root.val < q.val) || (root.val < p.val && root.val > q.val)) {
            resNode = root;
            return;
        }
        getCommonParentNode(root.left, p , q);
        getCommonParentNode(root.right, p , q);
    }
}
