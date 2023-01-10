package 二叉树;

public class 从中序与后序遍历序列构造二叉树 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        //需要头节点，左树，右树
        //前序遍历第一个就是头节点
        return buildHelper(inorder,0,inorder.length-1,postorder,0,postorder.length-1);
    }

    private TreeNode buildHelper(int[] inorder, int left1, int right1, int[] postorder, int left2, int right2) {
        //递归结束条件
        if (left1>right1 || left2>right2){
            return null;
        }
        int middle = left1;
        //边界是可以取到的
        for (int i = left1; i <= right1; i++) {
            if (inorder[i]==postorder[right2]){
                middle = i;
            }
        }
        TreeNode root = new TreeNode(postorder[right2]);
        root.left = buildHelper(inorder,left1,middle-1,postorder,left2,right2-(right1-middle)-1);
        root.right = buildHelper(inorder,middle+1,right1,postorder,right2-(right1-middle),right2-1);
        return root;
    }
}
