package 力扣热题100;

import 二叉树.TreeNode;
import 剑指offer100.股票的最大利润;

/**
 * @Author shizq18
 * @Date 2023/9/13
 * @Description
 */
public class 二叉树中的最大路径和 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(-2);
        root.right = new TreeNode(3);
//        root.right.left = new TreeNode(15);
//        root.right.right = new TreeNode(7);
        maxPath(root);
        System.out.println(res);
    }
    public int maxPathSum(TreeNode root) {
        // 求左节点最大路径，右节点最大路径
        return 0;
    }

    static int res = Integer.MIN_VALUE;
    public static int maxPath(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = maxPath(node.left);
        int right = maxPath(node.right);
        int maxPath = left+right+node.val;
        int bigChild = Math.max(left,right);
        res = calculateMax(res, maxPath, node.val,bigChild+ node.val);
        return bigChild > 0 ? bigChild + node.val : node.val;
    }

    private static int calculateMax(int v1, int v2, int v3, int v4) {
        return Math.max(v1,Math.max(v2,Math.max(v3,v4)));
    }
}
