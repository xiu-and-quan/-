package 剑指offer100;

import java.util.ArrayList;
import java.util.List;

public class 二叉树中和为某一值的路径 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right = new TreeNode(8);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(14);
        root.right.right.left = new TreeNode(5);
        root.right.right.right = new TreeNode(1);
        pathSum(root,22);
        resList.forEach(System.out::println);
    }
    static List<List<Integer>> resList = new ArrayList<>();
    public static List<List<Integer>> pathSum(TreeNode root, int target) {
        if (root == null){
            return resList;
        }
        //回溯
        List<Integer> array = new ArrayList<>();
        trace(root,target,array,0);
//        List<List<Integer>> res = new ArrayList<>();
//        if (resList.size() > 0){
//            for (int i = 0; i < resList.size(); i++) {
//                if (i % 2 == 0){
//                    res.add(resList.get(i));
//                }
//            }
//        }
        return resList;
    }

    private static void trace(TreeNode root, int target, List<Integer> array, int currentSum) {
        //结束条件
        if (root.left == null && root.right == null){
            if (currentSum+root.val == target) {
                array.add(root.val);
                resList.add(new ArrayList<>(array));
                array.remove(array.size()-1);
            }
            return;
        }
        TreeNode[] subTrees = new TreeNode[]{root.left, root.right};
        for (TreeNode element:
             subTrees) {
            if (element != null){
                //条件选择
                currentSum += root.val;
                array.add(root.val);
                trace(element, target, array, currentSum);
                currentSum -= root.val;
                array.remove(array.size() - 1);
            }
        }
    }
}
