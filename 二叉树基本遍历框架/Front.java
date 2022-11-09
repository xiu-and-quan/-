package 二叉树基本遍历框架;

public class Front {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(1);
        root.right = new TreeNode(2);
        front(root);
    }
    public static void front(TreeNode root){
        //结束条件
        if (root != null){
            System.out.println(root.value);
        }else {
            return;
        }
        front(root.left);
        front(root.right);
    }
}
