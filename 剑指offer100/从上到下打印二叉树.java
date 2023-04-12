package 剑指offer100;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 从上到下打印二叉树 {
    public int[] levelOrder(TreeNode root) {
        List<Integer> resList = new ArrayList<>();
        if (root == null){
            return new int[0];
        }
        //队列
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int size = queue.size();
//            for (int i = 0; i < size; i++) {
            TreeNode currentNode = queue.poll();
            resList.add(currentNode.val);
            if (currentNode.left != null){
                queue.add(currentNode.left);
            }
            if (currentNode.right != null){
                queue.add(currentNode.right);
            }
//            }
        }
        int resSize = resList.size();
        int[] res = new int[resSize];
        int index = 0;
        for (int element:
                resList) {
            res[index++] = element;
        }
        return res;
    }
}
