package 二叉树;

public class 填充每一个节点的下一个右侧节点 {
    public TreeNode connect(TreeNode root) {
        if(root==null){
            return root;
        }
        root.next = null;
        helper(root.left,root.right);
        return root;
    }

    public void helper(TreeNode left, TreeNode right){
        if(left != null && right !=null){
            left.next = right;
            right.next = null;
            helper(left.left,left.right);
            helper(left.right,right.left);
            helper(right.left,right.right);
        }

    }
}
