package 力扣热题100;

import 二叉树.TreeNode;

/**
 * @Author shizq18
 * @Date 2023/8/30
 * @Description
 */
public class 二叉树的最大深度 {
    public int maxDepth(TreeNode root) {
        if (root == null){
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right))+1;
    }
}
