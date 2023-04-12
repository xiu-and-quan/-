package 剑指offer100;

public class 二叉搜索树与双向链表 {
    public static void main(String[] args) {
        DoubleNode root = new DoubleNode(4);
        root.left = new DoubleNode(2);
        root.right = new DoubleNode(5);
        root.left.left = new DoubleNode(1);
        root.left.right = new DoubleNode(3);
        DoubleNode resDoubleNode = treeToDoublyList(root);
        int endCount = 0;
        while (resDoubleNode != null){
            System.out.print(resDoubleNode.val);
            resDoubleNode = resDoubleNode.right;
            endCount++;
            if (endCount == 10){
                break;
            }
        }
    }
    public static DoubleNode treeToDoublyList(DoubleNode root) {
        if (root == null){
            return null;
        }
        //二叉树的中序遍历是升序
        treeToDoublyListHelper(root);
        DoubleNode firstNode = null;
        DoubleNode lastNode = null;
        DoubleNode findFirstNode = root;
        DoubleNode lastFirstNode = root;
        while (findFirstNode.left != null){
            findFirstNode = findFirstNode.left;
        }
        firstNode = findFirstNode;
        while (lastFirstNode.right != null){
            lastFirstNode = lastFirstNode.right;
        }
        lastNode = lastFirstNode;

        firstNode.left = lastNode;
        lastNode.right = firstNode;

        return firstNode;
    }

    static DoubleNode preNode;
    private static void treeToDoublyListHelper(DoubleNode root) {
        if (root == null){
            return;
        }
        treeToDoublyListHelper(root.left);
        //中序遍历
        if (preNode!= null){
            preNode.right = root;
            root.left = preNode;
        }
        preNode = root;
        //中序遍历位置
        treeToDoublyListHelper(root.right);
    }
}

// Definition for a Node.
class DoubleNode {
    public int val;
    public DoubleNode left;
    public DoubleNode right;

    public DoubleNode() {}

    public DoubleNode(int _val) {
        val = _val;
    }

    public DoubleNode(int _val,DoubleNode _left,DoubleNode _right) {
        val = _val;
        left = _left;
        right = _right;
    }
}
