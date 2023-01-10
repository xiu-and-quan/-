package 二叉搜索树;

import 二叉树.TreeNode;

import java.util.ArrayList;
import java.util.Map;

public class 二叉搜索子树的最大键值和 {

    /*需要考虑以下几点：
    * root节点的左右子树是否是BST
    * root节点的左右子树的最大值最小值
    * root左右子树的节点之和*/
    public int maxSumBST(TreeNode root) {
        /*ArrayList<Integer> res = new ArrayList<>();
        helper(root,res);
        int maxValue = 0;
        for (int item:
             res) {
            maxValue = Math.max(maxValue,item);
        }
        return maxValue;*/
        traver(root);
        return maxValue;
    }

    int maxValue = Integer.MIN_VALUE;
    public int[] traver(TreeNode root){
        if (root == null){
            /*res[0]:是否是BST
            * res[1]:root为根的二叉树的所有节点的最小值
            * res[2]:root为根的二叉树的所有节点的最大值
            * res[3]:root为根的二叉树的所有节点值的和
            * */
            return new int[]{1,Integer.MAX_VALUE,Integer.MIN_VALUE,0};
        }
        int[] left = traver(root.left);
        int[] right = traver(root.right);
        /*后序遍历位置*/
        int[] res = new int[4];
        //判断root为根的是不是BST
        if (left[0] == 1 && right[0] == 1 && root.val > left[2] && root.val < right[1]){
            res[0] = 1;
            //计算root为根的二叉树的所有节点的最小值
            res[1] = Math.min(left[1], root.val);
            //计算root为根的二叉树的所有节点的最大值
            res[2] = Math.max(right[2],root.val);
            //计算root为根的二叉树的所有节点值的和
            res[3] = left[3] + right[3] + root.val;
            //更新全局变量
            maxValue = Math.max(maxValue,res[3]);
        } else {
            //不是BST
            res[0] = 0;
            //其他没有必要计算
        }
        return res;
    }

    //BST最大几点之和
    int maxSum = 0;
    public void helper(TreeNode root){
        if (root == null){
            return;
        }
        /*root节点的左右子树是否是BST
         * root节点的左右子树的最大值最小值
         * root左右子树的节点之和*/

        //root节点的左右子树是否是BST
        if (!isBST(root.left) || !isBST(root.right)){

        }
        //root节点的左右子树的最大值最小值
        int leftMax = findMax(root.left);
        int rightMin = findMin(root.right);
        //判断以root为节点的树是不是BST
        if (root.val <= leftMax || root.val >= rightMin){

        }
        //条件都符合，计算当前节点之和
        int leftSum = findSum(root.left);
        int rightSum = findSum(root.right);
        //计算BST节点的最大值
        this.maxSum = Math.max(maxSum,leftSum + rightSum + root.val);

        //递归左右子树
        helper(root.left);
        helper(root.right);
    }

}
class Test{
    public static void main(String[] args) {
        TreeNode root =new TreeNode(1);
        root.left = new TreeNode(4);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(2);
        root.right.right = new TreeNode(5);
        root.right.right.left = new TreeNode(4);
        root.right.right.right = new TreeNode(6);
        二叉搜索子树的最大键值和 test = new 二叉搜索子树的最大键值和();
        System.out.println(test.maxSumBST(root));;
    }
}
