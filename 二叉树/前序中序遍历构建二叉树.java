package 二叉树;

public class 前序中序遍历构建二叉树 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        //需要头节点，左树，右树
        //前序遍历第一个就是头节点
        return buildHelper(preorder,0,preorder.length-1,inorder,0,inorder.length-1);
    }

    private TreeNode buildHelper(int[] preorder, int left1, int right1, int[] inorder, int left2, int right2) {
        //递归结束条件
        if (left1>right1 || left2>right2){
            return null;
        }
        int middle = left2;
        //边界是可以取到的
        for (int i = left2; i <= right2; i++) {
            if (inorder[i]==preorder[left1]){
                middle = i;
            }
        }
        TreeNode root = new TreeNode(preorder[left1]);
        root.left = buildHelper(preorder,left1+1,left1+middle-left2,inorder,left2,middle-1);
        root.right = buildHelper(preorder,left1+middle-left2+1,right1,inorder,middle+1,right2);
        return root;
    }
}
