package 二叉树;

import java.util.LinkedList;

/**
 * @author fangsheng
 * @date 2021/7/9 10:23 上午
 */
public class T2 {
    private String SEP = ",";
    private static String NULL = "#";

    public String serialize3(TreeNode root) {
        StringBuilder stringBuilder = new StringBuilder();
        String serialize = serialize(root, stringBuilder);
        return serialize;
    }

    public String serialize(TreeNode root, StringBuilder stringBuilder) {
        if (root == null) {
            return stringBuilder.append(NULL).append(SEP).toString();
        }
        stringBuilder.append(root.val).append(SEP);
        serialize(root.left, stringBuilder);
        serialize(root.right, stringBuilder);
        return stringBuilder.toString();
    }

    public static TreeNode deserialize(String data) {
        LinkedList<String> linkedList = new LinkedList<>();
        String[] strings = data.split(",");
        for (int i = 0; i < strings.length; i++) {
            linkedList.add(strings[i]);
        }
        return deserialize(linkedList);
    }

    public static TreeNode deserialize(LinkedList<String> linkedList) {
        if (linkedList.isEmpty()) {
            return null;
        }
        String node = linkedList.removeFirst();
        if (node.equals(NULL)) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(node));
        root.left = deserialize(linkedList);
        root.right = deserialize(linkedList);
        return root;
    }

    public static void main(String[] args) {
        TreeNode deserialize = deserialize("1,2,#,#,3");
//        System.out.println(deserialize);

        LinkedList<String> strings = new LinkedList<>();
        strings.add("1");
        strings.add("3");
        strings.add("4");
        strings.add("2");
//        System.out.println(strings.removeFirst());
        System.out.println(strings.remove());
        System.out.println(strings);
    }
}

















