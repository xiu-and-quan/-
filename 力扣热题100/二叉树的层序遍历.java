package 力扣热题100;

import 二叉树.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author shizq18
 * @Date 2023/8/31
 * @Description
 */
public class 二叉树的层序遍历 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        List<List<Integer>> res = levelOrder(root);
        res.forEach(e->e.forEach(System.out::println));
    }
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> resList = new ArrayList<>();
        if (root == null) {
            return resList;
        }
        // 队列
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> subList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode currentNode = queue.poll();
                subList.add(currentNode.val);
                if (currentNode.left != null) {
                    queue.add(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.add(currentNode.right);
                }
            }
            resList.add(subList);
        }
        return resList;
    }
}
