package 二叉搜索树;

import 二叉树.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class 验证二叉搜索树的合法性 {
    public static void main(String[] args) {
       /* TreeNode root =new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(20);*/
        TreeNode root = null;
        System.out.println(isBST(root));


    }
    //二叉搜索树的性质 中序遍历是升序
  static boolean isBST(TreeNode root){
      isBSTHelper(root);
      System.out.println(list.size());
      for (int i = 1; i < list.size(); i++) {
          if (list.get(i-1)>list.get(i)){
              return false;
          }
      }
      return true;
    }
    static ArrayList<Integer> list = new ArrayList<>();
    private static void isBSTHelper(TreeNode root) {
        if (root == null){
            return;
        }
        isBSTHelper(root.left);
        list.add(root.val);
        isBSTHelper(root.right);
    }
}
