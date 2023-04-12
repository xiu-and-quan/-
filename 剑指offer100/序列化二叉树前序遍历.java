package 剑指offer100;

public class 序列化二叉树前序遍历 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        String dataString = serialize(root);
        System.out.println(dataString);
        TreeNode rootNew = deserialize(dataString);
        System.out.println(serialize(rootNew));
    }
    static StringBuilder string = new StringBuilder();
    static String emptyString = "null";
    public static String serialize(TreeNode root) {
        //后续遍历 到root节点时，可以拿到左右节点的数据
        serializeHelper(root);
        return string.toString();
    }

    private static void serializeHelper(TreeNode root) {
        if (root == null){
            string.append(emptyString).append(",");
            return;
        }
        string.append(root.val).append(",");
        serialize(root.left);
        serialize(root.right);
    }

    //前序遍历反序列化
    public static TreeNode deserialize(String data) {
        if (emptyString.equals(data)) {
            return null;
        }
        String[] stringsArray = data.split(",");
        return deserializeHelper(stringsArray,new int[]{0});
    }

    //基本数据类型是值传递 复杂类型是引用传递
    private static TreeNode deserializeHelper(String[] stringsArray, int[] index) {
        if (index[0] >= stringsArray.length || emptyString.equals(stringsArray[index[0]])){
            index[0]++;
            return null;
        }
        //index用了就需要+1
        TreeNode root = new TreeNode(Integer.parseInt(stringsArray[index[0]++]));
        root.left = deserializeHelper(stringsArray,index);
        root.right = deserializeHelper(stringsArray,index);
        return root;
    }
}
