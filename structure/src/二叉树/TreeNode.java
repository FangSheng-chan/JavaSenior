package 二叉树;

/**
 * @author fangsheng
 * @date 2021/6/24 9:54 上午
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode next;

    public TreeNode(int val) {
        this(val, null, null);
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    public void setNext(TreeNode next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "val=" + val +
                ", left=" + left +
                ", right=" + right +
                ", next=" + next +
                '}';
    }
}
