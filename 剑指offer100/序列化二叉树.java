package 剑指offer100;

import java.util.LinkedList;
import java.util.Queue;

public class 序列化二叉树 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        //System.out.println(serialize(root));
        String data = serialize(root);
        System.out.println(data);
        TreeNode rootNew = deserialize(data);
        System.out.print(serialize(rootNew));
    }
    public static String empty = "null";
    // Encodes a tree to a single string.
    public static String serialize(TreeNode root) {
        if (root == null){
            return null;
        }
        //层序遍历 队列
        StringBuilder res = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode currentNode = queue.poll();
            if (currentNode == null){
                res.append(empty).append(',');
            }else {
                res.append(currentNode.val).append(',');
                //left
                queue.add(currentNode.left);
                //right
                queue.add(currentNode.right);
            }
        }
        return res.toString();
    }

    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
        if (data == null){
            return null;
        }
        String[] dataArray = data.split(",");
        //层序遍历恢复二叉树
        //二叉树的构建就是左节点右节点
        int size = dataArray.length;
        TreeNode root = new TreeNode(Integer.parseInt(dataArray[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        for (int i = 1; i < size; i+=2) {
            TreeNode current = queue.poll();
            String left = dataArray[i] ,right = dataArray[i + 1];
            if (!("null".equals(left))){
                current.left = new TreeNode(Integer.parseInt(left));
                queue.add(current.left);
            }
            if (!("null".equals(right))){
                current.right = new TreeNode(Integer.parseInt(right));
                queue.add(current.right);
            }
        }
        return root;
    }

}
