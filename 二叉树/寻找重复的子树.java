package 二叉树;

import sun.reflect.generics.tree.Tree;

import java.util.*;

public class 寻找重复的子树 {

    public static void main(String[] args) {
        TreeNode root =new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(2);
        root.right.right = new TreeNode(4);
        root.right.left.left = new TreeNode(4);
        System.out.println(findDuplicateSubtrees(root));
    }
    //考虑用HashMap key为重复的子树，value为；此子树的个数
    // 最后只需要遍历拿出value>1的结果组成返回值
    static HashMap<String,Integer> hashMap = new HashMap<>();
    static List<TreeNode> res = new ArrayList<>();
    public static List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        //后续遍历，把每一个子节点放进去
        afterHelper(root);
        //遍历hashMap
        return res;
    }


    private static String afterHelper(TreeNode root) {
        if (root == null){
            return "#";
        }
        String leftStr = afterHelper(root.left);
        String rightStr = afterHelper(root.right);
        String treeStr = root.val +","+ leftStr +","+ rightStr;
        if(hashMap.getOrDefault(treeStr,0) == 1){
            res.add(root);
        }
        hashMap.put(treeStr,hashMap.getOrDefault(treeStr,0)+1);
        return treeStr;
    }
}
