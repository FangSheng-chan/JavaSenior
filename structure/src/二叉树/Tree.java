package 二叉树;

import java.util.Stack;

/**
 * @author fangsheng
 * @date 2021/6/23 9:49 上午
 */
public class Tree<AnyType extends Comparable<? super AnyType>> {

    private static class BinaryNode<AnyType> {
        BinaryNode(AnyType theElement) {
            this(theElement, null, null);
        }

        BinaryNode(AnyType theElement, BinaryNode<AnyType> lt, BinaryNode<AnyType> rt) {
            element = theElement;
            left = lt;
            right = rt;
        }

        AnyType element;
        BinaryNode<AnyType> left;
        BinaryNode<AnyType> right;
    }

    private BinaryNode<AnyType> root;

    public void insert(AnyType x) {
        root = insert(x, root);
    }

    public boolean isEmpty() {
        return root == null;
    }

    private BinaryNode<AnyType> insert(AnyType x, BinaryNode<AnyType> t) {
        if (t == null) {
            return new BinaryNode<>(x, null, null);
        }

        int compareResult = x.compareTo(t.element);

        if (compareResult < 0) {
            t.left = insert(x, t.left);
        } else if (compareResult > 0) {
            t.right = insert(x, t.right);
        } else {
            ;
        }

        return t;
    }

    /**
     * 前序遍历
     * 递归
     */
    public void preOrder(BinaryNode<AnyType> Node) {
        if (Node != null) {
            System.out.print(Node.element + " ");
            preOrder(Node.left);
            preOrder(Node.right);
        }
    }

    /**
     * 中序遍历
     * 递归
     */
    public void midOrder(BinaryNode<AnyType> Node) {
        if (Node != null) {
            midOrder(Node.left);
            System.out.print(Node.element + " ");
            midOrder(Node.right);
        }
    }

    /**
     * 后序遍历
     * 递归
     */
    public void posOrder(BinaryNode<AnyType> Node) {
        if (Node != null) {
            posOrder(Node.left);
            posOrder(Node.right);
            System.out.print(Node.element + " ");
        }
    }

    /*
     * 层序遍历
     * 递归
     */
    public void levelOrder(BinaryNode<AnyType> Node) {
        if (Node == null) {
            return;
        }

        int depth = depth(Node);

        for (int i = 1; i <= depth; i++) {
            levelOrder(Node, i);
        }
    }

    private void levelOrder(BinaryNode<AnyType> Node, int level) {
        if (Node == null || level < 1) {
            return;
        }

        if (level == 1) {
            System.out.print(Node.element + "  ");
            return;
        }

        // 左子树
        levelOrder(Node.left, level - 1);

        // 右子树
        levelOrder(Node.right, level - 1);
    }

    public int depth(BinaryNode<AnyType> Node) {
        if (Node == null) {
            return 0;
        }

        int l = depth(Node.left);
        int r = depth(Node.right);
        if (l > r) {
            return l + 1;
        } else {
            return r + 1;
        }
    }

    /**
     * 前序遍历
     * 非递归
     */
    public void preOrder1(BinaryNode<AnyType> Node) {
        Stack<BinaryNode> stack = new Stack<>();
        while (Node != null || !stack.empty()) {
            while (Node != null) {
                System.out.print(Node.element + "   ");
                stack.push(Node);
                Node = Node.left;
            }
            if (!stack.empty()) {
                Node = stack.pop();
                Node = Node.right;
            }
        }
    }
}

