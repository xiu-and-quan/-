package 力扣热题100;

import 二叉树.TreeNode;

/**
 * @Author shizq18
 * @Date 2023/9/5
 * @Description
 */
public class 从前序与中序遍历序列构造二叉树 {
    public static void main(String[] args) {
        buildTree(new int[]{3,9,20,15,7}, new int[]{9,3,15,20,7});
    }
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder,0,inorder.length-1,inorder,0,inorder.length-1);
    }

    private static TreeNode buildTree(int[] preorder, int start1, int end1, int[] inorder, int start2, int end2) {
        if (start1 > end1 || start2 > end2) {
            return null;
        }
        int rootValue = preorder[start1];
        int middle = start2;
        for (int i = start2; i <= end2; i++) {
            if (rootValue == inorder[i]) {
                middle = i;
            }
        }
        TreeNode root = new TreeNode(rootValue);
        root.left = buildTree(preorder,start1+1,start1+middle-start2,inorder,start2,middle-1);
        root.right = buildTree(preorder,start1+middle-start2+1,end1,inorder,middle+1,end2);
        return root;
    }
}
