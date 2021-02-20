package struct01;

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
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        // 让左右子节点继续翻转它们的子节点
        invertTree(root.left);
        invertTree(root.right);

        return root;
    }


}
