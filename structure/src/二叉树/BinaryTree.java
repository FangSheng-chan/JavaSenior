package 二叉树;

import org.jetbrains.annotations.Nullable;
import org.junit.Test;

import java.util.*;

/**
 * 写二叉树的算法题，都是基于递归框架的，
 * 我们先要搞清楚 root 节点它自己要做什么，然后根据题目要求选择使用前序，中序，后续的递归框架。
 *
 * @author fangsheng
 * @date 2021/6/23 9:40 上午
 */
public class BinaryTree {

    private TreeNode root;

    public void setRoot(TreeNode root) {
        this.root = root;
    }

    @Override
    public String toString() {
        return "BinaryTree{" +
                "root=" + root +
                '}';
    }

    /**
     * 向二叉树中插入节点
     *
     * @param root
     * @param data
     */
    public void insert(TreeNode root, int data) {
        //二叉排序树的右节点都比根节点大
        if (data > root.val) {
            if (root.right == null) {
                root.right = new TreeNode(data);
            } else {
                //递归插入子节点
                this.insert(root.right, data);
            }
        }
        //二叉排序树的左节点都比根节点小
        else {
            if (root.left == null) {
                root.left = new TreeNode(data);
            } else {
                //递归插入子节点
                this.insert(root.left, data);
            }
        }
    }

    public void insertLeft(int data) {
        insertLeft(root, data);
    }

    public void insertLeft(TreeNode root, int data) {
        if (root.left == null) {
            root.left = new TreeNode(data);
        } else {
            this.insertLeft(root.left, data);
        }
    }

    public void insertRight(int data) {
        insertRight(root, data);
    }

    public void insertRight(TreeNode root, int data) {
        if (root.right == null) {
            root.right = new TreeNode(data);
        } else {
            this.insertRight(root.right, data);
        }
    }

    public void infixOrder(TreeNode root) {
        if (root != null) {
            infixOrder(root.left);
            System.out.print(root.val + "\t");
            infixOrder(root.right);
        }
    }

    public void lastOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        lastOrder(root.left);
        lastOrder(root.right);
        System.out.print(root.val + "\t");
    }

    public void middleOrder(TreeNode treeNode) {
        Stack<TreeNode> stack = new Stack<>();
        while (treeNode != null || !stack.isEmpty()) {
            while (treeNode != null) {
                stack.push(treeNode);
                treeNode = treeNode.left;
            }
            if (!stack.isEmpty()) {
                treeNode = stack.pop();
                System.out.println(treeNode.val);
                treeNode = treeNode.right;
            }
        }
    }

    /**
     * 二叉树遍历框架
     * 快速排序就是二叉树的前序遍历
     * 归并排序就是二叉树的后序遍历
     *
     * @param root
     */
    void traver(TreeNode root) {
        //前序遍历
        traver(root.left);
        //中序遍历
        traver(root.right);
        //后序遍历
    }

    /**
     * 统计二叉树的节点个数
     *
     * @param root
     * @return
     */
    public int count(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + count(root.left) + count(root.right);
    }

    /**
     * 翻转二叉树（深度优先遍历）
     *
     * @param root
     * @return
     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }

    /**
     * 翻转二叉树（广度优先遍历）
     *
     * @param root
     * @return
     */
    public TreeNode invertTree2(TreeNode root) {
        if (root == null) {
            return null;
        }
        //将二叉树中的节点逐层放入队列中，再迭代处理队列中的元素
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            //每次都从队列中拿一个节点，并交换这个节点的左右子树
            TreeNode tmp = queue.poll();
            TreeNode left = tmp.left;
            tmp.left = tmp.right;
            tmp.right = left;
            //如果当前节点的左子树不为空，则放入队列等待后续处理
            if (tmp.left != null) {
                queue.add(tmp.left);
            }
            //如果当前节点的右子树不为空，则放入队列等待后续处理
            if (tmp.right != null) {
                queue.add(tmp.right);
            }

        }
        //返回处理完的根节点
        return root;
    }


    /**
     * 填充完美二叉树每个节点的下一个右侧节点指针
     *
     * @param root
     * @return
     */
    public TreeNode connect3(TreeNode root) {
        if (root == null) {
            return null;
        }
        connectTwoNode(root.left, root.right);
        return root;
    }

    void connectTwoNode(TreeNode node1, TreeNode node2) {
        if (node1 == null || node2 == null) {
            return;
        }
        //前序遍历
        node1.next = node2;
        connectTwoNode(node1.left, node1.right);
        connectTwoNode(node2.left, node2.right);
        connectTwoNode(node1.right, node2.left);
    }

    public TreeNode connect(TreeNode root) {
        if (root == null) {
            return null;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (queue.size() > 0) {
            int size = queue.size();
            TreeNode tmp = queue.get(0);
            for (int i = 1; i < size; i++) {
                tmp.next = queue.get(i);
                tmp = queue.get(i);
            }
            for (int i = 0; i < size; i++) {
                tmp = queue.remove();
                if (tmp.left != null) {
                    queue.add(tmp.left);
                }
                if (tmp.right != null) {
                    queue.add(tmp.right);
                }
            }
        }
        return root;
    }

    public TreeNode connect2(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode pre = root;
        while (pre.left != null) {
            TreeNode tmp = pre;
            while (tmp != null) {
                tmp.left.next = tmp.right;
                if (tmp.next != null) {
                    tmp.right.next = tmp.next.left;
                }
                tmp = tmp.next;
            }
            pre = pre.left;
        }
        return root;
    }

    /**
     * 将二叉树转成链表
     *
     * @param root
     */
    public void flatten(TreeNode root) {
        while (root != null) {
            if (root.left != null) {
                // 找左子树最右边的节点
                TreeNode pre = root.left;
                while (pre.right != null) {
                    pre = pre.right;
                }
                //将原来的右子树接到左子树的最右边节点
                pre.right = root.right;
                // 将左子树插入到右子树的地方
                root.right = root.left;
                root.left = null;
                // 考虑下一个节点
            }
            root = root.right;
        }
    }

    void flatten2(TreeNode root) {
        if (root == null) {
            return;
        }
        flatten2(root.left);
        flatten2(root.right);
        TreeNode left = root.left;
        TreeNode right = root.right;
        root.left = null;
        root.right = left;
        TreeNode p = root;
        while (p.right != null) {
            p = p.right;
        }
        p.right = right;
    }

    static TreeNode constructMaximumBinaryTree(int[] nums) {
        return build(nums, 0, nums.length - 1);
    }

    static TreeNode build(int[] nums, int lo, int hi) {
        if (lo > hi) {
            return null;
        }
        int index = -1, maxVal = Integer.MIN_VALUE;
        for (int i = lo; i <= hi; i++) {
            if (maxVal < nums[i]) {
                index = i;
                maxVal = nums[i];
            }
        }
        TreeNode root = new TreeNode(maxVal);
        root.left = build(nums, lo, index - 1);
        root.right = build(nums, index + 1, hi);
        return root;
    }

    String SEP = ",";
    String NULL = "#";

    public String serialize(TreeNode root) {
        StringBuilder stringBuilder = new StringBuilder();
        serialize(root, stringBuilder);
        return stringBuilder.toString();
    }

    void serialize(TreeNode root, StringBuilder stringBuilder) {
        if (root == null) {
            stringBuilder.append(NULL).append(SEP);
            return;
        }
        stringBuilder.append(root.val).append(SEP);
        serialize(root.left, stringBuilder);
        serialize(root.right, stringBuilder);
    }

    TreeNode deserialize(String data) {
        LinkedList<String> nodes = new LinkedList<>();
        for (String s : data.split(",")) {
            nodes.add(s);
        }
        return deserialize(nodes);
    }

    TreeNode deserialize(LinkedList<String> nodes) {
        if (nodes.isEmpty()) {
            return null;
        }
        String first = nodes.removeFirst();
        if (first.equals(NULL)) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(first));
        root.left = deserialize(nodes);
        root.right = deserialize(nodes);
        return root;
    }

    void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        //初始化队列，将root 加入队列
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            //层级遍历代码位置
            System.out.println(cur.val);
            if (cur.left != null) {
                queue.offer(cur.left);
            }
            if (cur.right != null) {
                queue.offer(cur.right);
            }
        }
    }

//    TreeNode buildTree(int[] preorder, int[] inorder) {
//
//    }

    @Test
    public void t1() {
        TreeNode deserialize = deserialize("1,2,#,#,3,");
        System.out.println(deserialize);
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 6, 0, 5};
        TreeNode treeNode = constructMaximumBinaryTree(nums);
        System.out.println(treeNode);

    }
}
























