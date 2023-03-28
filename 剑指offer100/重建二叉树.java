package 剑指offer100;

public class 重建二叉树 {
    public static void main(String[] args) {
        TreeNode res = buildTree(new int[]{3,9,20,15,7},new int[]{9,3,15,20,7});
        frontInteator(res);
    }
    //前序和中序遍历构建二叉树
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        //构建二叉树 需要知道左右子树 递归
        int rootValue = preorder[0];
        int rootIndex = 0;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == rootValue){
                rootIndex = i;
                break;
            }
        }
        TreeNode root = new TreeNode(rootValue);
        //leftSubTree
        root.left = buildTreeHelpFunction(preorder,1,rootIndex,inorder,0,rootIndex-1);
        //rightSubTree
        root.right = buildTreeHelpFunction(preorder,rootIndex+1,preorder.length,inorder,rootIndex+1,inorder.length-1);
        return root;
    }

    public static TreeNode buildTreeHelpFunction(int[] preorder, int start1, int end1, int[] inorder, int start2, int end2) {
        if (start1>end1 || start2 > end2){
            return null;
        }
        if (start1 >= preorder.length){
            return null;
        }
        int rootValue = preorder[start1];
        int rootIndex = 0;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == rootValue){
                rootIndex = i;
                break;
            }
        }
        TreeNode root = new TreeNode(rootValue);
        root.left = buildTreeHelpFunction(preorder,start1+1,start1+rootIndex-start2,inorder,start2,rootIndex-1);
        //rightSubTree
        root.right = buildTreeHelpFunction(preorder,start1+rootIndex-start2+1,end1,inorder,rootIndex+1,end2);
        return root;
    }

    public static void frontInteator(TreeNode root){
        if (root != null){
            System.out.println(root.val);
        }
        if (root.left != null)
        frontInteator(root.left);

        if (root.right != null)
        frontInteator(root.right);
    }
}
/**
 * Definition for a binary tree node.
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
