package 二叉树;

/**
 * @author fangsheng
 * @date 2021/6/23 9:39 上午
 */
public class Test {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        TreeNode root = new TreeNode(1);
        insertNode(binaryTree, root);
        String serialize = binaryTree.serialize(root);
        System.out.println(serialize);
//        binaryTree.flatten2(root);
//        System.out.println(root);
//        System.out.println(root.left.left);
//        binaryTree.flatten(root);
//        System.out.println(binaryTree);
    }

    private static void insertNode(BinaryTree binaryTree, TreeNode root) {
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(5);
        TreeNode node5 = new TreeNode(6);
        TreeNode node6 = new TreeNode(7);
        TreeNode node7 = new TreeNode(8);
        TreeNode node8 = new TreeNode(9);
        TreeNode node9 = new TreeNode(10);
        TreeNode node10 = new TreeNode(11);
        binaryTree.setRoot(root);
        root.setLeft(node1);
        root.setRight(node2);
//        node1.setLeft(node3);
//        node1.setRight(node4);
//        node2.setLeft(node5);
        node2.setRight(node6);
//        node3.setLeft(node7);
//        node3.setRight(node8);
//        node4.setLeft(node9);
//        node4.setRight(node10);
    }

    /**
     * 在树上面插节点
     */
    private static void t3() {
        BinaryTree binaryTree = new BinaryTree();
        TreeNode root = new TreeNode(0);
        binaryTree.setRoot(root);
        binaryTree.insertLeft(1);
        binaryTree.insertLeft(3);
        binaryTree.insertLeft(4);
        binaryTree.insertRight(2);
        binaryTree.insertRight(5);
        binaryTree.insertRight(6);
        binaryTree.infixOrder(root);
    }

    /**
     * 把节点排序好后再插入
     */
    private static void t2() {
        int[] a = {44, 76, 35, 22, 16, 48, 90, 46, 9, 40};
        BinaryTree binaryTree = new BinaryTree();
        TreeNode root = new TreeNode(a[0]);
        for (int i = 1; i < a.length; i++) {
            binaryTree.insert(root, a[i]);
        }
        binaryTree.infixOrder(root);
    }

    /**
     * 在节点中插入节点
     */
    private static void t1(BinaryTree binaryTree, TreeNode root) {
        binaryTree.middleOrder(root);
    }
}
