package 牛客剑指;

import 二叉树.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author shizq18
 * @Date 2023/6/19
 * @Description
 */
public class 二叉树的下一个结点 {
    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        TreeLinkNode target = pNode;
        TreeLinkNode tempNode = pNode;
        // 先找root节点
        while (tempNode.next != null) {
            tempNode = tempNode.next;
        }
        // 中序遍历找到对应节点
        findNextNode(tempNode);
        for (int i = 0; i < list.size()-1; i++) {
            if (list.get(i).equals(target)) {
                return list.get(i+1);
            }
        }
        return null;
    }
     List<TreeLinkNode> list = new ArrayList<>();
    private void findNextNode(TreeLinkNode root) {
        if (root==null) {
            return;
        }
        findNextNode(root.left);
        list.add(root);
        findNextNode(root.right);
    }
}
class TreeLinkNode {
    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    TreeLinkNode next = null;

    TreeLinkNode(int val) {
        this.val = val;
    }
}