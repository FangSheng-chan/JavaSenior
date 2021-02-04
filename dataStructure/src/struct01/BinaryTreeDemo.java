package struct01;

/**
 * @author fangsheng
 * @date 2021/2/4 下午3:53
 */
public class BinaryTreeDemo {
    public static void main(String[] args) {

        BinaryTree binaryTree = new BinaryTree();

        TreeNode root = new TreeNode(1, "1");
        TreeNode node2 = new TreeNode(2, "2");
        TreeNode node3 = new TreeNode(3, "3");
        TreeNode node4 = new TreeNode(4, "4");
        TreeNode node5 = new TreeNode(5, "5");
        TreeNode node6 = new TreeNode(6, "6");

        root.setLeft(node2);
        root.setRight(node3);
        node2.setLeft(node4);
        node2.setRight(node5);
        node4.setLeft(node6);
        binaryTree.setRoot(root);

        // 先序遍历
        System.out.println("先序遍历");
        binaryTree.preOrder();
        System.out.println("中序遍历");
        binaryTree.infixOrder();
        System.out.println("翻转二叉树");
        binaryTree.invertTree(root);
        System.out.println("先序遍历");
        binaryTree.preOrder();
        System.out.println("先序遍历查找");
        TreeNode treeNode = binaryTree.preOrderSearch(3);
        System.out.println(treeNode);
    }
}
