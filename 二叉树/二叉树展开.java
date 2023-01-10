package 二叉树;

import sun.reflect.generics.tree.Tree;

public class 二叉树展开 {
    public void flatten(TreeNode root) {
        if(root == null){
            return;
        }
        //辅助函数
        flatten(root.left);
        flatten(root.right);

        TreeNode leftNode  = root.left;
        TreeNode rightNode = root.right;
        root.left = null;
        root.right = leftNode;
        TreeNode p = root;
        while (p.right !=null){
            p = p.right;
        }
        p.right = rightNode;
    }

}
