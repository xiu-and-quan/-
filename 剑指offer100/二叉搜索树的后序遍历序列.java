package 剑指offer100;

public class 二叉搜索树的后序遍历序列 {
    public static void main(String[] args) {
        System.out.println(verifyPostorder(new int[]{4, 8, 6, 12, 16, 14, 10}));
    }
    public static boolean verifyPostorder(int[] postorder) {
        if (postorder == null || postorder.length == 0) {
            return true;
        }
        return verifySequenceOfBST(postorder, 0, postorder.length - 1);
    }

    private static boolean verifySequenceOfBST(int[] sequence, int start, int end) {
        if (start >= end) {
            return true;
        }
        int root = sequence[end];
        int i = start;
        while (i < end && sequence[i] < root) {
            i++;
        }
        for (int j = i; j < end; j++) {
            if (sequence[j] < root) {
                return false;
            }
        }
        return verifySequenceOfBST(sequence, start, i - 1) && verifySequenceOfBST(sequence, i, end - 1);
    }
}