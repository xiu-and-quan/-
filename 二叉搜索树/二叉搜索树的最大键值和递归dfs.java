package 二叉搜索树;

import 二叉树.TreeNode;

public class 二叉搜索树的最大键值和递归dfs {
    public int maxSumBST(TreeNode root) {
        dfs(root);
        return maxSumRes;
    }

    int maxSumRes = 0;
    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        dfs(root.right);
        //判断是否是合法的二叉搜索树
        boolean isBST = isBST(root);
        if (isBST) {
            int tempSubSum = findSum(root);
            maxSumRes = Math.max(tempSubSum, maxSumRes);
        }
    }

    private int findSum(TreeNode node) {
        if (node == null){
            return 0;
        }
        int leftSum = findSum(node.left);
        int rightSum = findSum(node.right);
        return node.val + leftSum + rightSum;
    }

    private boolean isBST(TreeNode root) {
        //验证二叉搜索树 需要考虑两层节点 类似奇数偶数
        return checkBTSHelper(root,null,null);
    }
    boolean checkBTSHelper(TreeNode root,TreeNode min,TreeNode max){
        //1、当前root要大于左节点，小于右节点
        //2、当前root的值要大于左子树的最大节点和小于右子树的最小节点
        if (root == null){
            return true;
        }
        if (min != null && root.val <= min.val){
            return false;
        }
        if (max != null && root.val >= max.val){
            return false;
        }
        return checkBTSHelper(root.left,min,root) && checkBTSHelper(root.right,root,max);
    }
}
