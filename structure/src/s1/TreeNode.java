package s1;

/**
 * @author fangsheng
 * @date 2021/2/4 下午3:35
 */
public class TreeNode {
    int no;
    Integer val;
    TreeNode left;
    TreeNode right;
    TreeNode next;

    public TreeNode(Integer val) {
        this.val = val;
    }

    public TreeNode(int no, Integer val) {
        this.no = no;
        this.val = val;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Integer getVal() {
        return val;
    }

    public void setVal(Integer val) {
        this.val = val;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    public TreeNode getNext() {
        return next;
    }

    public void setNext(TreeNode next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "no=" + no +
                ", val='" + val + '\'' +
                ", left=" + left +
                ", right=" + right +
                ", next=" + next +
                '}';
    }

    /**
     * 编写先序遍历的方法
     */
    public void preOrder() {
        TreeNode treeNode = this;
        System.out.println(treeNode);
        //递归向左子树前序遍历
        if (this.left != null) {
            this.left.preOrder();
        }
        if (this.right != null) {
            this.right.preOrder();
        }
    }

    /**
     * 中序遍历
     */
    public void infixOrder() {
        if (this.left != null) {
            this.left.infixOrder();
        }
        System.out.println(this);
        if (this.right != null) {
            this.right.infixOrder();
        }
    }

    /**
     * 先(根)序遍历
     *
     * @param no
     * @return
     */
    public TreeNode preOrdersearch(int no) {
        if (this.no == no) {
            return this;
        }
        TreeNode resNode = null;
        if (this.left != null) {
            resNode = this.left.preOrdersearch(no);
        }
        if (resNode != null) {
            return resNode;
        }
        if (this.right != null) {
            resNode = this.right.preOrdersearch(no);
        }
        return resNode;
    }
}



