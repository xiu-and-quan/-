package 剑指offer100;

public class 二叉树的镜像 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);
        printFront(mirrorTree(root));

    }
    public static TreeNode mirrorTree(TreeNode root) {
        if(root == null){
            return null;
        }
        TreeNode tempLeft = root.left;
        root.left = root.right;
        root.right = tempLeft;
        mirrorTree(root.left);
        mirrorTree(root.right);
        return root;
    }
    //前序遍历
   static void printFront(TreeNode root){
        if (root == null){
            return;
        }
        System.out.println(root.val);
        printFront(root.left);
        printFront(root.right);
    }
}
