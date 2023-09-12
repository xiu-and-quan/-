package 力扣热题100;

import 二叉树.TreeNode;

import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

/**
 * @Author shizq18
 * @Date 2023/9/7
 * @Description
 */
public class 路径总和III {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.left.right = new TreeNode(2);
        root.left.right.right = new TreeNode(1);
        root.right = new TreeNode(-3);
        root.right.right = new TreeNode(11);
        root.left.left = new TreeNode(3);
        root.left.left.right = new TreeNode(-2);
        root.left.left.left = new TreeNode(3);
        // pathSum(root,8);

    }

    public int pathSum(TreeNode root, int targetSum) {
        // 遍历每一个节点然后判断
        if (root == null) {
            return 0;
        }
        // 前序遍历计算每一个节点作为头节点的情况
        int resCount = pathCount(root, targetSum);
        resCount += pathSum(root.left, targetSum);
        resCount += pathSum(root.right, targetSum);
        return resCount;
    }

    private int pathCount(TreeNode root, int targetSum) {
        int ret = 0;

        if (root == null) {
            return 0;
        }
        if (root.val == targetSum) {
            ret++;
        }
        ret += pathCount(root.left, targetSum - root.val);
        ret += pathCount(root.right, targetSum - root.val);
        return ret;
    }


    public int pathSumPrefix(TreeNode root, int targetSum) {
        Map<Long, Integer> prefix = new HashMap<Long, Integer>();
        prefix.put(0L, 1);
        return dfs(root, prefix, 0, targetSum);
    }

    public int dfs(TreeNode root, Map<Long, Integer> prefix, long curr, int targetSum) {
        if (root == null) {
            return 0;
        }

        int ret = 0;
        curr += root.val;

        ret = prefix.getOrDefault(curr - targetSum, 0);
        prefix.put(curr, prefix.getOrDefault(curr, 0) + 1);
        ret += dfs(root.left, prefix, curr, targetSum);
        ret += dfs(root.right, prefix, curr, targetSum);
        prefix.put(curr, prefix.getOrDefault(curr, 0) - 1);

        return ret;
    }
}