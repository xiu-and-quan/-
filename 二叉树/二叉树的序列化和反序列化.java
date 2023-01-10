package 二叉树;

import com.sun.deploy.util.StringUtils;

import java.util.LinkedList;
import java.util.Queue;

public class 二叉树的序列化和反序列化 {
    public static void main(String[] args) {
        TreeNode root =new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        //System.out.println(serialize(root));
        TreeNode res = deserialize("1,2,#,#,3,4,5,#,#,#,#");
        front(res);
    }
    static StringBuilder stringBuilder = new StringBuilder();
    public static String serialize(TreeNode root) {
        //前序遍历
        if (root == null){
            return null;
        }
        serializeHelper(root);
        return new String(stringBuilder);

    }

    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
        //反序列化
        //因为是前序遍历
        String[] strings = data.split(",");
        Queue<String> queue = new LinkedList<>();
        for (int i = 0; i < strings.length; i++) {
            queue.add(strings[i]);
        }
        return deserializeHelper(queue);
    }

    private static TreeNode deserializeHelper(Queue<String> queue) {
        if (queue.isEmpty()){
            return null;
        }
        //左侧节点结束条件
        String currStr = queue.poll();
        if (currStr.equals("#")){
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(currStr));
        root.left = deserializeHelper(queue);
        root.right = deserializeHelper(queue);
        return root;
    }

    private static void serializeHelper(TreeNode root) {
        if (root == null){
            stringBuilder.append("#").append(",");
            return;
        }else {
            stringBuilder.append(root.val).append(",");
        }
        serializeHelper(root.left);
        serializeHelper(root.right);
    }

    public static void front(TreeNode root){
        if (root == null){
            return;
        }
        System.out.println(root.val);
        front(root.left);
        front(root.right);
    }
}
