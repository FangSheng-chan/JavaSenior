package com.ss.t5;

import java.util.LinkedList;
import java.util.Queue;

public class cengcibianli<E extends Comparable<E>> {


    private void cengci(Node<E> root) {
        Queue<Node<E>> queue = new LinkedList<>();
        Node<E> currentNode = null;
        queue.offer(root);
        while (!queue.isEmpty()) {
            currentNode = queue.poll();

            Node<E> right = currentNode.right;

            System.out.println(currentNode);
            if (currentNode.left != null) {
                queue.offer(currentNode.left);
            }
            if (currentNode.right != null) {
                queue.offer(currentNode.right);
            }
        }
    }

}

/**
 * 结点
 */
class Node<E extends Comparable<E>> {

    E value;
    Node<E> left;
    Node<E> right;

    Node(E value) {
        this.value = value;
        left = null;
        right = null;
    }
}

class myNode{
    private int value;
    myNode left,right;

    public myNode(int value, myNode left, myNode right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }
}
