package s1;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author fangsheng
 * @date 2021/2/4 下午3:58
 */
public class BinaryTree {
    private TreeNode root;

    public TreeNode getRoot() {
        return root;
    }

    public void setRoot(TreeNode root) {
        this.root = root;
    }

    /**
     * 前序遍历
     */
    public void preOrder() {
        if (this.root != null) {
            this.root.preOrder();
        } else {
            System.out.println("二叉树为空，无法遍历");
        }
    }

    /**
     * 中序遍历
     */
    public void infixOrder() {
        if (this.root != null) {
            this.root.infixOrder();
        } else {
            System.out.println("二叉树为空，无法遍历");
        }
    }

    /**
     * 先序遍历查找
     *
     * @param no
     * @return
     */
    public TreeNode preOrderSearch(int no) {
        if (root != null) {
            return root.preOrdersearch(no);
        } else {
            return null;
        }
    }

    /**
     * 计算二叉树共有几个节点
     * <p>
     * 定义：count(root) 返回以 root 为根的树有多少节点
     *
     * @param root
     * @return
     */
    int count(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + count(root.left) + count(root.right);
    }

    /**
     * 翻转二叉树
     *
     * @param root
     * @return
     */
    TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        // 前序遍历
        // root 节点需要交换它的左右子节点
        //  就是交换左右节点
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        // 让左右子节点继续翻转它们的子节点
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }

    TreeNode connect2(TreeNode root) {
        if (root == null) {
            return null;
        }
        root.left.next = root.right;
        connect2(root.left);
        connect2(root.right);
        return root;
    }

    TreeNode connect(TreeNode root) {
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
        node1.next = node2;
        connectTwoNode(node1.left, node1.right);
        connectTwoNode(node2.left, node2.right);
        connectTwoNode(node1.right, node1.left);
    }

    /**
     * 将以root为根的数拉平为链表
     *
     * @param root
     */
    void flatten(TreeNode root) {
        flatten(root.left);
        flatten(root.right);
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

    /**
     * 最大二叉树
     *
     * @param nums
     * @return
     */
    TreeNode constructMaximumBinaryTree(int[] nums) {
        return build(nums, 0, nums.length - 1);
    }

    /**
     * 只要明白根节点做了啥，就一次递归下去即可
     *
     * @param nums
     * @param lo
     * @param hi
     * @return
     */
    TreeNode build(int[] nums, int lo, int hi) {
        if (lo > hi) {
            return null;
        }
        int index = -1, max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (max < nums[i]) {
                index = i;
                max = nums[i];
            }
        }
        TreeNode root = new TreeNode(max);
        root.left = build(nums, lo, index - 1);
        root.right = build(nums, index + 1, hi);
        return root;
    }

    /**
     * 寻找重复子树
     *
     * @param root
     * @return
     */

    HashMap<String, Integer> memo = new HashMap<>();

    LinkedList<TreeNode> res = new LinkedList<>();

    List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        // 如何知道以自己根的二叉树长啥样？
        traverse(root);
        return res;
    }

    String traverse(TreeNode root) {
        if (root == null) {
            return "#";
        }
        String left = traverse(root.left);
        String right = traverse(root.right);
        String subTree = left + "," + right + ',' + root.val;
        int freq = memo.getOrDefault(subTree, 0);
        //多次重复也只会加入结果集一次
        if (freq == 1) {
            res.add(root);
        }
        memo.put(subTree, freq + 1);
        return subTree;
    }

    /**
     * 二叉树的序列化
     */

    String SEP = ",";
    String NULL = "#";

    public String serialize(TreeNode root) {
        StringBuilder stringBuilder = new StringBuilder();
        serialize(root, stringBuilder);
        return stringBuilder.toString();
    }

    void serialize(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append(NULL).append(SEP);
            return;
        }
        sb.append(root.val).append(SEP);

        serialize(root.left, sb);
        serialize(root.right, sb);
    }

    /***
     *
     * 前序遍历
     *
     * 字符串反序列化
     * @param data
     * @return
     */
    public TreeNode deserialize(String data) {
        LinkedList<String> nodes = new LinkedList<>();
        for (String s : data.split(SEP)) {
            nodes.addLast(s);
        }
        return deserialize(nodes);
    }

    /**
     * 字符串反序列化
     *
     * @param nodes
     * @return
     */
    TreeNode deserialize(LinkedList<String> nodes) {
        if (nodes.isEmpty()) {
            return null;
        }
        String first = nodes.removeFirst();
        if (first.equals("#")) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(first));
        root.left = deserialize(nodes);
        root.right = deserialize(nodes);
        return root;
    }


    /**
     * 层级遍历的模版
     *
     * @param root
     */
    void traverse3(TreeNode root) {
        if (root == null) {
            return;
        }
        //初始化队列，将root 加入队列
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            //层级遍历代码位置
            System.out.println(root.val);
            if (cur.left != null) {
                queue.offer(cur.left);
            }
            if (cur.right != null) {
                queue.offer(cur.right);
            }
        }
    }

    /**
     * 层级遍历序列化
     */
    void traverse2(TreeNode root) {
        if (root == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if (cur == null) {
                continue;
            }
            System.out.println(root.val);

            queue.offer(cur.left);
            queue.offer(cur.right);
        }
    }

    // 记录结果
    int result = 0;

    //记录当前元素的排名
    int rank = 0;

    int kthSmallest(TreeNode root, int k) {
        traverse4(root, k);
        return result;
    }

    /**
     * 中序遍历的结果是有序的
     *
     * @param root
     * @param k
     */
    void traverse4(TreeNode root, int k) {
        if (root == null) {
            return;
        }
        traverse4(root.left, k);
        rank++;
        if (k == rank) {
            result = root.val;
            return;
        }
        traverse4(root.right, k);
    }

    void traverse(TreeNode root, int k) {
        if (root == null) {
            return;
        }
        traverse(root.left, k);
        rank++;
        if (rank == k) {
            result = root.val;
            return;
        }
        traverse(root.right, k);
    }

    /**
     * 将二叉搜索树转换为累加数
     *
     * @param root
     * @return
     */
    TreeNode convertBST(TreeNode root) {
        traverse7(root);
        return root;
    }

    int sum = 0;
    void traverse7(TreeNode root) {
        if (root == null) {
            return;
        }
        traverse7(root.right);
        sum += root.val;
        root.val = sum;
        traverse7(root.left);
    }

    /**
     * 中序遍历 从小到大
     *
     * @param root
     */
    void traverse5(TreeNode root) {
        if (root == null) {
            return;
        }
        traverse(root.left);
        System.out.println(root.val);
        traverse(root.right);
    }

    /**
     * 中序遍历 从大到小
     *
     * @param root
     */
    void traverse6(TreeNode root) {
        if (root == null) {
            return;
        }
        traverse(root.right);
        System.out.println(root.val);
        traverse(root.left);
    }

}
