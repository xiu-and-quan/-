package 剑指offer100;

/**
 * @author shizq18
 * @since 2023/4/25
 */
public class 平衡二叉树 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.right.right = new TreeNode(3);
        root.left.left.left = new TreeNode(4);
        root.right.right.left = new TreeNode(4);
        System.out.println(isBalanced(root));
    }
    /**
     * 输入一棵二叉树的根节点，判断该树是不是平衡二叉树。
     * 如果某二叉树中任意节点的左右子树的深度相差不超过1，
     * 那么它就是一棵平衡二叉树。
     */

    public static boolean res = true;
    public static boolean isBalanced(TreeNode root) {
        if (root == null){
            return true;
        }
        //后续遍历
        return res = Math.abs(findDeepLength(root.left) -findDeepLength(root.right)) <= 1
                && isBalanced(root.left)
                && isBalanced(root.right);
    }

    private static int findDeepLength(TreeNode node) {
        if (node == null){
            return 0;
        }
        return Math.max(findDeepLength(node.left), findDeepLength(node.right)) + 1;
    }

}
