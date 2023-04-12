package 剑指offer100;

import java.util.*;

public class 从上到下打印二叉树III {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(levelOrder(root));
    }
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> resList = new ArrayList<>();
        if (root == null){
            return resList;
        }
        //双队列
        Queue<TreeNode> queue1 = new LinkedList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();
        queue1.add(root);
        queue2.add(root);
        int direction = 0;
        while (!queue1.isEmpty()){
            int size = queue1.size();
            List<Integer> subList = new ArrayList<>();
                for (int i = 0; i < size; i++) {
                    TreeNode currentNode1 = queue1.poll();
                    TreeNode currentNode2 = queue2.poll();

                    if (currentNode1.left != null) {
                        queue1.add(currentNode1.left);
                    }
                    if (currentNode1.right != null) {
                        queue1.add(currentNode1.right);
                    }
                    if (currentNode2.right != null) {
                        queue2.add(currentNode2.right);
                    }
                    if (currentNode2.left != null) {
                        queue2.add(currentNode2.left);
                    }
                    if (direction % 2 == 0){
                        subList.add(currentNode1.val);
                    }else {
                        subList.add(currentNode2.val);
                    }
                }
                direction++;
                resList.add(subList);
        }
        return resList;
    }
}
