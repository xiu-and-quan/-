package 二叉树;

public class 后续遍历 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        after(root);
    }
    public static void after(TreeNode root){
        if (root == null){
            return;
        }
        after(root.left);
        after(root.right);
        if (root != null){
            System.out.println(root.val);
        }else {
            return;
        }
    }
}
