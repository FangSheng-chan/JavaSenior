package 多叉树;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @author fangsheng
 * @date 2021/3/30 上午10:20
 */
public class T1 {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode();
        ArrayList<TreeNode> list = new ArrayList<>();
        treeNode.setChildren(list);

    }

    public static void Recursion(TreeNode root) {
        System.out.println(root.getName());
        for (TreeNode treeNode : root.getChildren()) {
            Recursion(treeNode);
        }
    }

    /**
     * 广度优先需要构建一个先进先出的队列
     *
     * @param root
     */
    public static void breadthFirst(TreeNode root) {
        LinkedList<TreeNode> nodeDeque = new LinkedList<>();
        TreeNode node = root;
        nodeDeque.push(node);
        while (!nodeDeque.isEmpty()) {
            node = nodeDeque.pop();
            System.out.println(node.getName());
            for (TreeNode treeNode : node.getChildren()) {
                nodeDeque.addLast(treeNode);
            }
        }
    }

    /**
     * 构造一个后进先出的栈
     * 不使用 stack 是因为 Java 的 stack 功能略多
     *
     * @param root
     */
    public static void depthFirst(TreeNode root) {
        Deque<TreeNode> nodeDeque = new LinkedList<>();
        TreeNode node = root;
        nodeDeque.push(node);
        while (!nodeDeque.isEmpty()) {
            node = nodeDeque.pop();
            System.out.println(node.getName());
            for (TreeNode treeNode : node.getChildren()) {
                nodeDeque.push(treeNode);
            }
        }
    }


}
