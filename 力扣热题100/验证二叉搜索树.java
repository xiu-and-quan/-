package 力扣热题100;

import 二叉树.TreeNode;

/**
 * @Author shizq18
 * @Date 2023/9/1
 * @Description
 */
public class 验证二叉搜索树 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        // root.left = new TreeNode(1);
        root.right = new TreeNode(1);
        boolean result = isValidBST(root);
        System.out.println(result);
    }
    static Integer preValue = Integer.MIN_VALUE;
    static boolean res = true;
    static int firstCount = 0;
    public static boolean isValidBST(TreeNode root) {
        // 二叉搜索树中序遍历是升序的
        isValidBSTHelp(root);
        return res;
    }

    private static void isValidBSTHelp(TreeNode root) {
        if (root == null) {
            return;
        }
        isValidBSTHelp(root.left);
        // 中序遍历位置
        int currentValue = root.val;
        // 起始第一个点
        if (firstCount == 0){
            firstCount = 2;
        } else {
            if (currentValue <= preValue) {
                res = res && false;
                return;
            }
        }
        preValue = currentValue;
        isValidBSTHelp(root.right);
    }

    public static boolean isValidBSTRecursion(TreeNode root) {
        // 二叉搜索树中序遍历是升序的
        return isValid(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    /**
     * 二叉搜索数需要跨层传递最大最小值
     * @param root
     * @param minValue
     * @param maxValue
     * @return
     */
    private static boolean isValid(TreeNode root, long minValue, long maxValue) {
        if (root == null) {
            return true;
        }
        if (root.val <= minValue || root.val >= maxValue) {
            return false;
        }
        return isValid(root.left,minValue,root.val) && isValid(root.right,root.val,maxValue);
    }
}
