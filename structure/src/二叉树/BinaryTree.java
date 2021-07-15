package 二叉树;

import org.jetbrains.annotations.Nullable;
import org.junit.Test;

import java.util.*;

/**
 * 写二叉树的算法题，都是基于递归框架的， 我们先要搞清楚 root 节点它自己要做什么，然后根据题目要求选择使用前序，中序，后续的递归框架。
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
    return "BinaryTree{" + "root=" + root + '}';
  }

  /**
   * 向二叉树中插入节点
   *
   * @param root
   * @param data
   */
  public void insert(TreeNode root, int data) {
    // 二叉排序树的右节点都比根节点大
    if (data > root.val) {
      if (root.right == null) {
        root.right = new TreeNode(data);
      } else {
        // 递归插入子节点
        this.insert(root.right, data);
      }
    }
    // 二叉排序树的左节点都比根节点小
    else {
      if (root.left == null) {
        root.left = new TreeNode(data);
      } else {
        // 递归插入子节点
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
   * 二叉树遍历框架 快速排序就是二叉树的前序遍历 归并排序就是二叉树的后序遍历
   *
   * @param root
   */
  void traver(TreeNode root) {
    if (root != null) {
      // 前序遍历
      traver(root.left);
      // 中序遍历
      traver(root.right);
      // 后序遍历
      System.out.println(root.val);
    } else {
      System.out.println("#");
    }
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
    int left = count(root.left);
    int right = count(root.right);
    int res = left + right + 1;
    return res;
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
    // 将二叉树中的节点逐层放入队列中，再迭代处理队列中的元素
    LinkedList<TreeNode> queue = new LinkedList<>();
    queue.add(root);
    while (!queue.isEmpty()) {
      // 每次都从队列中拿一个节点，并交换这个节点的左右子树
      TreeNode tmp = queue.poll();
      TreeNode left = tmp.left;
      tmp.left = tmp.right;
      tmp.right = left;
      // 如果当前节点的左子树不为空，则放入队列等待后续处理
      if (tmp.left != null) {
        queue.add(tmp.left);
      }
      // 如果当前节点的右子树不为空，则放入队列等待后续处理
      if (tmp.right != null) {
        queue.add(tmp.right);
      }
    }
    // 返回处理完的根节点
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
    // 前序遍历
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
        // 将原来的右子树接到左子树的最右边节点
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

  /**
   * 构造最大二叉树
   *
   * @param nums
   * @return
   */
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

  String serial(TreeNode root) {
    if (root == null) {
      return "#";
    }
    String left = serial(root.left);
    String right = serial(root.right);
    String subTree = left + right + root.val;
    return subTree;
  }

  String serialize2(TreeNode root) {
    // 对于空节点，可以用一个特殊字符表示
    if (root == null) {
      return "#";
    }
    // 将左右子树序列化成字符串
    String left = serialize2(root.left);
    String right = serialize2(root.right);
    /* 后序遍历代码位置 */
    // 左右子树加上自己，就是以自己为根的二叉树序列化结果
    String subTree = left + "," + right + "," + root.val;
    //        System.out.println(subTree);
    return subTree;
  }

  String SEP = ",";
  String NULL = "#";

  /**
   * 前序遍历序列化
   *
   * @param root
   */
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

  /**
   * 前序遍历反序列化
   *
   * @param data
   * @return
   */
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

  /**
   * 深度优先遍历二叉树
   *
   * @param root
   */
  void dfsTree(TreeNode root) {
    if (root == null) {
      return;
    }
    Stack<TreeNode> stack = new Stack<>();
    stack.push(root);
    while (!stack.isEmpty()) {
      TreeNode s = stack.pop();
      System.out.println(s.val);
      if (s.right != null) {
        stack.push(s.right);
      }
      if (s.left != null) {
        stack.push(s.left);
      }
    }
  }

  /**
   * 广度优先遍历二叉树
   *
   * @param root
   */
  void bfsTree(TreeNode root) {
    if (root == null) {
      return;
    }
    // 初始化队列，将root 加入队列
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);

    while (!queue.isEmpty()) {
      TreeNode cur = queue.poll();
      // 层级遍历代码位置
      System.out.println(cur.val);
      if (cur.left != null) {
        queue.offer(cur.left);
      }
      if (cur.right != null) {
        queue.offer(cur.right);
      }
    }
  }

  /**
   * 通过前序和中序得到二叉树
   *
   * @param preorder
   * @param inorder
   * @return
   */
  TreeNode buildTree(int[] preorder, int[] inorder) {
    return build(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
  }

  TreeNode build(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
    if (preStart > preEnd) {
      return null;
    }
    // root 节点对应的值就是前序遍历数组的第一个元素
    int rootVal = preorder[preStart];
    // rootVal 在中序遍历数组中的索引
    int index = 0;
    for (int i = inStart; i <= inEnd; i++) {
      if (inorder[i] == rootVal) {
        index = i;
        break;
      }
    }
    int leftSize = index - inStart;
    TreeNode root = new TreeNode(rootVal);
    root.left = build(preorder, preStart + 1, preStart + leftSize, inorder, inStart, index - 1);
    root.right = build(preorder, preStart + leftSize + 1, preEnd, inorder, index + 1, inEnd);
    return root;
  }

  /**
   * 通过中序遍历和后序遍历构造二叉树
   *
   * @param inorder
   * @param postorder
   * @return
   */
  TreeNode buildTree2(int[] inorder, int[] postorder) {
    return build2(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
  }

  TreeNode build2(
      int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd) {
    if (inStart > inEnd) {
      return null;
    }
    // root 节点对应的值就是后序遍历数组的最后一个元素
    int rootVal = postorder[postEnd];
    // rootVal 在中序遍历数组中的索引
    int index = 0;
    for (int i = inStart; i <= inEnd; i++) {
      if (inorder[i] == rootVal) {
        index = i;
        break;
      }
    }
    // 左子树的节点个数
    int leftSize = index - inStart;
    TreeNode root = new TreeNode(rootVal);
    // 递归构造左右子树
    root.left = build(inorder, inStart, index - 1, postorder, postStart, postStart + leftSize - 1);

    root.right = build(inorder, index + 1, inEnd, postorder, postStart + leftSize, postEnd - 1);
    return root;
  }

  // 记录所有子树以及出现的次数
  HashMap<String, Integer> memo = new HashMap<>();
  // 记录重复的子树根节点
  LinkedList<TreeNode> res = new LinkedList<>();

  /**
   * 如何判断我们应该用前序还是中序还是后序遍历的框架？ 思考一个二叉树节点需要做什么，到底用什么遍历顺序就清楚了。
   *
   * @param root
   * @return
   */
  List<TreeNode> findDuplicateSubtrees(TreeNode root) {
    traverse(root);
    return res;
  }

  String traverse(TreeNode root) {
    if (root == null) {
      return "#";
    }
    String left = traverse(root.left);
    String right = traverse(root.right);
    String subTree = left + "," + right + "," + root.val;
    int freq = memo.getOrDefault(subTree, 0);
    // 多次重复也只会被加入结果集一次
    if (freq == 1) {
      res.add(root);
    }
    // 给子树对应的出现次数加一
    memo.put(subTree, freq + 1);
    return subTree;
  }

  /***************** 二分树搜索树*****************/

  public TreeNode inorderPredecessor(TreeNode root, TreeNode p) {
    TreeNode succ = null;
    while (root != null) {
      if (p.val <= root.val) {
        root = root.left;
      } else {
        if (succ == null || root.val > succ.val) {
          succ = root;
        }
        root = root.right;
      }
    }
    return succ;
  }

  int kthSmallestRes = 0;
  int rank = 0;

  /**
   * 寻找第K小的值
   *
   * @param root
   * @param k
   * @return
   */
  public int kthSmallest(TreeNode root, int k) {
    traverse(root, k);
    return kthSmallestRes;
  }

  void traverse(TreeNode root, int k) {
    if (root == null) {
      return;
    }
    traverse(root.left, k);
    rank++;
    if (k == rank) {
      kthSmallestRes = root.val;
      return;
    }
    traverse(root.right, k);
  }

  /** BST转换为累加树 */
  int sum = 0;

  TreeNode convertBST(TreeNode root) {
    traverse2(root);
    return root;
  }

  /**
   * 修改递归的顺序，降序遍历BST
   *
   * @param root
   */
  void traverse2(TreeNode root) {
    if (root == null) {
      return;
    }
    traverse2(root.right);
    sum += root.val;
    root.val = sum;
    traverse2(root.left);
  }

  /**
   * 不同二叉搜索树 穷举
   *
   * @param n
   * @return
   */
  // 备忘录
  //    int[][] memo2;

  int numTrees(int n) {
    // 备忘录的值初始化为 0
    //        memo2 = new int[n + 1][n + 1];
    return count(1, n);
  }

  /**
   * 笛卡尔积
   *
   * @param lo
   * @param hi
   * @return
   */
  int count(int lo, int hi) {
    if (lo > hi) {
      return 1;
    }
    //        // 查备忘录
    //        if (memo2[lo][hi] != 0) {
    //            return memo2[lo][hi];
    //        }
    int res = 0;
    for (int mid = lo; mid <= hi; mid++) {
      int left = count(lo, mid - 1);
      int right = count(mid + 1, hi);
      res += left * right;
    }
    // 将结果存入备忘录
    //        memo2[lo][hi] = res;
    return res;
  }

  List<TreeNode> generateTree(int n) {
    if (n == 0) {
      return new LinkedList<>();
    }
    // 构造闭区间 [1, n] 组成的 BST
    return build(1, n);
  }

  /* 构造闭区间 [lo, hi] 组成的 BST */
  List<TreeNode> build(int lo, int hi) {
    List<TreeNode> res = new LinkedList<>();
    // base case
    if (lo > hi) {
      res.add(null);
      return res;
    }
    // 1、穷举 root 节点的所有可能。
    for (int i = lo; i <= hi; i++) {
      // 2、递归构造出左右子树的所有合法 BST。
      List<TreeNode> leftTree = build(lo, i - 1);
      List<TreeNode> rightTree = build(i + 1, hi);
      // 3、给 root 节点穷举所有左右子树的组合。
      for (TreeNode left : leftTree) {
        for (TreeNode right : rightTree) {
          // i 作为根节点 root 的值
          TreeNode root = new TreeNode(i);
          root.left = left;
          root.right = right;
          res.add(root);
        }
      }
    }
    return res;
  }

//  TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {}

  @Test
  public void t2() {
    int[] preorder = {1, 2, 5, 4, 6, 7, 3, 8, 9};
    int[] inorder = {5, 2, 6, 4, 7, 1, 8, 3, 9};
    TreeNode treeNode = buildTree(preorder, inorder);
    System.out.println(treeNode);
  }

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
