package 剑指offer100;

import java.util.Stack;

/**
 * @Author shizq18
 * @Date 2023/5/4
 * @Description
 */
public class 二叉搜索树的第k大节点 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        //root.left = new TreeNode(1);
        root.right = new TreeNode(2);
        //root.left.right = new TreeNode(2);
        System.out.println(kthLargest(root, 2));
    }
    public static int kthLargest(TreeNode root, int k) {
        //栈先进后出
        Stack<Integer> treeNodeValue = new Stack<>();
        //二叉搜索树中序遍历是升序
        middleIterator(root, treeNodeValue);
        int resValue = 0;
        int size = treeNodeValue.size();
        for (int i = 0; i < size; i++) {
            Integer currentValue = treeNodeValue.pop();
            k--;
            if (k == 0){
                resValue = currentValue;
                break;
            }
        }
        return resValue;
    }

    private static void middleIterator(TreeNode root, Stack<Integer> treeNodeValue) {
        if (root == null){
            return;
        }
        //中序遍历位置
        middleIterator(root.left, treeNodeValue);
        treeNodeValue.push(root.val);
        middleIterator(root.right, treeNodeValue);
    }
}
