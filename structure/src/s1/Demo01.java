package s1;

/**
 * @author fangsheng
 * @date 2021/1/27 5:05 下午
 */
public class Demo01 {

    /**
     * 数组遍历框架
     *
     * @param arr
     */
    void teaverseArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            //迭代反问arr[i]
        }
    }

    /**
     * 单链表节点
     */
    class ListNode {
        int val;
        ListNode next;

        public ListNode(int x) {
            this.val = x;
        }
    }

    void teaverseLinked(ListNode head) {
        for (ListNode p = head; p != null; p = p.next) {
            //迭代反问 p.val
        }
    }

    /**
     * 递归访问head.val
     */
    void teaverseRecursion(ListNode head) {
        teaverseRecursion(head.next);
    }

    /**
     * 基本二叉树节点
     */
    class TreeNode {
        int val;
        TreeNode left, right;
    }

    /**
     * @param root
     */
    void traverseTreeNode(TreeNode root) {
        traverseTreeNode(root.left);
        traverseTreeNode(root.right);
    }

    class NTreeNode {
        int val;
        NTreeNode[] children;
    }

    void traverseNTreeNode(NTreeNode root) {
        for (NTreeNode child : root.children) {
            traverseNTreeNode(child);
        }
    }

    public static void main(String[] args) {
        System.out.println("ss");
    }


}
