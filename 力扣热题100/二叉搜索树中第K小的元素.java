package 力扣热题100;

import 二叉树.TreeNode;

/**
 * @Author shizq18
 * @Date 2023/9/4
 * @Description
 */
public class 二叉搜索树中第K小的元素 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
//        root.left = new TreeNode(1);
//        root.left.right = new TreeNode(2);
        root.right = new TreeNode(2);
        int res = kthSmallest(root,2);
        System.out.println("success");
    }
    static int value;
    static int direction;
    public static int kthSmallest(TreeNode root, int k) {
        findKthElement(root,k);
        return value;
    }

    private static void findKthElement(TreeNode root, int k) {
        if (root == null) {
            return;
        }
        findKthElement(root.left, k);
        direction++;
        // 中序遍历位置
        if (k == direction) {
            value = root.val;
            return;
        }
        findKthElement(root.right, k);
    }
}
