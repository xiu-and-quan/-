package 动态规划;

public class 打家劫舍III {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(3);
        root.right.right = new TreeNode(1);
        System.out.println(rob(root));
    }
    public static int rob(TreeNode root) {
        return helperFunction(root);
    }

    private static int helperFunction(TreeNode root) {
        if (root == null){
            return 0;
        }
        //偷
        int rob = (root.left==null?0:(helperFunction(root.left.left)+helperFunction(root.left.right)))
                 + (root.right==null?0:(helperFunction(root.right.left)+helperFunction(root.right.right)))
                 + root.val;
        //不偷
        int notRob = helperFunction(root.left)+helperFunction(root.right);
        return Math.max(rob,notRob);
    }
}

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
}
