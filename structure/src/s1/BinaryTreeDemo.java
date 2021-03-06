package s1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * @author fangsheng
 * @date 2021/2/4 下午3:53
 */
public class BinaryTreeDemo {
    public static void main(String[] args) {

        BinaryTree binaryTree = new BinaryTree();

        TreeNode node1 = new TreeNode(1, 1);
        TreeNode node2 = new TreeNode(2, 2);
        TreeNode node3 = new TreeNode(3, 3);
        TreeNode node4 = new TreeNode(4, 4);
        TreeNode node5 = new TreeNode(5, 5);
        TreeNode node6 = new TreeNode(6, 6);
        TreeNode node7 = new TreeNode(7, 7);

        binaryTree.setRoot(node3);
        node3.setLeft(node2);
        node3.setRight(node4);
        node2.setLeft(node1);
        node4.setLeft(node6);
        node4.setRight(node7);
        node1.setLeft(node5);


        int depth = binaryTree.minDepth(node3);
        System.out.println(depth);

//
//        List<String> stringList = binaryTree.serialize3(node3);
//        System.out.println(stringList);
//
//
//        String s = binaryTree.serialize2(node3);
//        System.out.println(s);

//        String s = "1,2,#,4,#,#,3,#,#,";
//        TreeNode treeNode = binaryTree.deserialize2(s);
//        System.out.println(treeNode);

//        String val = binaryTree.serialize2(node3);
//        System.out.println(val);

//        int inBST2 = binaryTree.getVal(node3, 2);
//        System.out.println(inBST2);
//        boolean validBST = binaryTree.isValidBST(node3);
//        System.out.println(validBST);

//        TreeNode treeNode = binaryTree.convertBST(node3);
//        System.out.println(treeNode);

//        TreeNode deserialize = binaryTree.deserialize("1,2,#,4,#,#,3,#,#,");
//        System.out.println(deserialize);

//        String serialize = binaryTree.serialize(root);
//        System.out.println(serialize);

//        List<TreeNode> subtrees = binaryTree.findDuplicateSubtrees(root);
//        for (TreeNode subtree : subtrees) {
//            System.out.println(subtree);
//        }

//        TreeNode p = root;
//        while (p.right != null) {
//            p = p.right;
//        }
//        System.out.println(p);

//        int count = binaryTree.count(root);
//        System.out.println(count);
//
//        TreeNode connect = binaryTree.connect(root);
//        System.out.println(connect);

        // 先序遍历
//        System.out.println("先序遍历");
//        binaryTree.preOrder();
//        System.out.println("中序遍历");
//        binaryTree.infixOrder();
//        System.out.println("翻转二叉树");
//        binaryTree.invertTree(root);
//        System.out.println("先序遍历");
//        binaryTree.preOrder();
//        System.out.println("先序遍历查找");
//        TreeNode treeNode = binaryTree.preOrderSearch(3);
//        System.out.println(treeNode);
    }
}
