package 剑指offer100;

public class 树的子结构 {
    //先对问题进行分割
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        boolean result = false;
        if(A != null && B != null) {
            if(A.val == B.val) {
                result = doesTree1HaveTree2(A, B);
            }
            if(!result) {
                result = isSubStructure(A.left, B);
            }
            if(!result) {
                result = isSubStructure(A.right, B);
            }
        }
        return result;
    }

    private boolean doesTree1HaveTree2(TreeNode node1, TreeNode node2) {
        if(node2 == null) {
            return true;
        }
        if(node1 == null) {
            return false;
        }
        if(node1.val != node2.val) {
            return false;
        }
        return doesTree1HaveTree2(node1.left, node2.left) && doesTree1HaveTree2(node1.right, node2.right);
    }
}