package 力扣热题100;

import 二叉树.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author shizq18
 * @Date 2023/8/30
 * @Description
 */
public class 二叉树的中序遍历 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helpMiddleTraver(res,root);
        return res;
    }

    private void helpMiddleTraver(List<Integer> res, TreeNode root) {
        if (root == null) {
            return;
        }
        helpMiddleTraver(res, root.left);
        res.add(root.val);
        helpMiddleTraver(res, root.right);
    }
}
