package 牛客剑指;

import 二叉树.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author shizq18
 * @Date 2023/7/6
 * @Description
 */
public class 序列化二叉树 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        // String serializeStrTree = Serialize(root);
        // Deserialize(serializeStrTree);
    }
    /*
    * 层序遍历
    * */
    String Serialize(TreeNode root) {
        if (root == null) {
            return null;
        }
        // bfs
        Queue<TreeNode> queue = new LinkedList<>();
        StringBuilder stringBuilder = new StringBuilder();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode current = queue.poll();
                if (current == null) {
                    stringBuilder.append("#").append(",");
                    continue;
                } else {
                    stringBuilder.append(current.val).append(",");
                }
                queue.add(current.left);
                queue.add(current.right);
            }
        }
        return stringBuilder.deleteCharAt(stringBuilder.length()-1).toString();
    }
    TreeNode Deserialize(String str) {
        if (str == null) {
            return null;
        }
        String[] serializeStrTree = str.split(",");
        // 队列
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.valueOf(serializeStrTree[0]));
        int index = 1;
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode currentNode = queue.poll();
                if (!"#".equals(serializeStrTree[index])) {
                    currentNode.left = new TreeNode(Integer.valueOf(serializeStrTree[index++]));
                    queue.add(currentNode.left);
                } else {
                    index++;
                }
                if (!"#".equals(serializeStrTree[index])) {
                    currentNode.right = new TreeNode(Integer.valueOf(serializeStrTree[index++]));
                    queue.add(currentNode.right);
                } else {
                    index++;
                }
            }
        }
        return root;
    }
}
