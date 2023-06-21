package 牛客剑指;

import sun.reflect.generics.tree.Tree;
import 二叉树.TreeNode;
import 单链表问题.ListNode;

/**
 * @Author shizq18
 * @Date 2023/6/19
 * @Description
 */
public class 重建二叉树 {
    public static void main(String[] args) {
        TreeNode res = reConstructBinaryTree(new int[]{1,2,4,7,3,5,6,8}, new int[]{4,7,2,1,5,3,8,6});
        // 2 4 7   , 4 7 2
        // 4 7 ,   4 7
        printTree(res);
    }
    /*给定节点数为 n 的二叉树的前序遍历和中序遍历结果，请重建出该二叉树并返回它的头结点。
    例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}*/
    public static TreeNode reConstructBinaryTree (int[] preOrder, int[] vinOrder) {
        // write code here
        // 前序遍历第一个是头节点
        return buildTree(preOrder, 0, preOrder.length-1, vinOrder, 0, vinOrder.length-1);

    }

    private static TreeNode buildTree(int[] preOrder, int start1, int end1, int[] vinOrder, int start2, int end2) {
        if (start2 > end2 || start1 > end1) {
            return null;
        }

        TreeNode root = new TreeNode(preOrder[start1]);
        int rootIndex = 0;
        for (int i = start2; i <= end2; i++) {
            if (vinOrder[i] == preOrder[start1]) {
                rootIndex = i;
                break;
            }
        }
        int length = rootIndex - start2;
        root.left = buildTree(preOrder, start1+1, start1+length, vinOrder, start2, start2+length-1);
        root.right = buildTree(preOrder, start1+length+1, end1, vinOrder, rootIndex+1, end2);
        return root;
    }

    private static void printTree(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root != null) {
            System.out.println(root.val);
        }
        printTree(root.left);
        printTree(root.right);
    }
}
