package 剑指offer100;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class 二叉树中和为某一值的路径DFS {
    public List<List<Integer>> pathSum(TreeNode root, int target) {
        dfs(root,target);
        return resList;
    }
    List<List<Integer>> resList = new LinkedList<List<Integer>>();
    List<Integer> path = new LinkedList<>();
    private void dfs(TreeNode root, int target) {
        if (root == null) {
            return;
        }
        path.add(root.val);
        target -= root.val;
        if (root.left == null && root.right == null && target == 0){
            resList.add(new ArrayList<>(path));
        }
        dfs(root.right,target);
        dfs(root.right,target);
        path.remove(path.size()-1);
    }
}
