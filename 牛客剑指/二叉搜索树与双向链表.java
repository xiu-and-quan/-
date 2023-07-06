package 牛客剑指;

import 二叉树.TreeNode;

/**
 * @Author shizq18
 * @Date 2023/7/4
 * @Description
 */
public class 二叉搜索树与双向链表 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.right = new TreeNode(3);
        root.right.right.right = new TreeNode(4);
        root.right.right.right.right = new TreeNode(5);
        Convert(root);
    }
    static TreeNode preNode;
    static TreeNode head;

    static int first = 1;
    public static TreeNode Convert(TreeNode pRootOfTree) {
        // 二叉搜索树中序遍历是升序
        if (pRootOfTree == null) {
            return null;
        }
        Convert(pRootOfTree.left);
        // 中序遍历位置
        if (preNode != null) {
            pRootOfTree.left = preNode;
            preNode.right = pRootOfTree;
        }
        preNode = pRootOfTree;
        // 链表开始节点
        if (first == 1 && (pRootOfTree.left == null || pRootOfTree.right == null)) {
            head = pRootOfTree;
            first++;
        }
        // 需要找到上一个节点和当前节点
        Convert(pRootOfTree.right);
        return head;
    }
}
