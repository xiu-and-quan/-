package BFS;

import 二叉树.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class 二叉树的最小深度 {
    public int minDepth(TreeNode root) {
        //BFS
        if (root == null){
            return 0;
        }
        //queeu
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int deepNum = 1;
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode current = queue.poll();
                if (current.left == null && current.right == null){
                    return deepNum;
                }
                if (current.left != null){
                    queue.add(current.left);
                }
                if (current.right != null){
                    queue.add(current.right);
                }
            }
            deepNum++;
        }
        return deepNum;
    }
}
