package struct01;

/**
 * 链表的插入
 *
 * @author fangsheng
 * @date 2021/1/28 10:17 上午
 */
public class Demo02 {

    private ListNode head;

    private ListNode left;

    public Demo02() {
        head = new ListNode();
    }

    @Override
    public String toString() {
        return "Demo02{" +
                "head=" + head +
                '}';
    }

    /**
     * 单链表节点的结构
     */
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }

        public ListNode() {
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }

    /**
     * 头插入
     *
     * @param val
     */
    public void insertHeadNode(int val) {
        ListNode listNode = new ListNode(val);
        listNode.next = head.next;
        head.next = listNode;
    }

    /**
     * 尾插法
     *
     * @param val
     */
    public void insertTailNode(int val) {
        // 找到尾巴
        ListNode cur = head;
        // 遍历结点
        while (cur.next != null) {
            cur = cur.next;
        }
        // 得到结点
        ListNode listNode = new ListNode(val);
        cur.next = listNode;
    }

    /***
     * 任意结点插入
     * @param val
     * @param pos
     * @return
     */
    public boolean insertPosNode(int val, int pos) {
        if (pos < 0 || pos >= getLength() + 1) {
            return false;
        }
        ListNode cur = head;
        for (int i = 0; i <= pos - 1; i++) {
            cur = cur.next;
        }
        ListNode listNode = new ListNode(val);
        listNode.next = cur.next;
        cur.next = listNode;
        return true;
    }


    public int getLength() {
        int len = 0;
        ListNode cur = head.next;
        while (cur != null) {
            len++;
            cur = cur.next;
        }
        return len;
    }

    ListNode reverse(ListNode head) {
        if (head.next == null) {
            return head;
        }
        ListNode last = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }

    /**
     * 反转链表前N个节点
     *
     * @param head
     * @param n
     * @return
     */
    ListNode successor = null;

    ListNode reverseN(ListNode head, int n) {
        if (n == 1) {
            successor = head.next;
            return head;
        }
        ListNode last = reverseN(head.next, n - 1);
        head.next.next = head;
        head.next = successor;
        return last;
    }

    void test() {
        int x = 90;
        int y = 100;
        while (y > 0) {
            if (x > 100) {
                x = x - 10;
                y--;
            } else {
                x++;
            }
        }
    }

    /**
     * 反转一个区间内的节点
     *
     * @param head
     * @param m
     * @param n
     * @return
     */
    ListNode reverseBetween(ListNode head, int m, int n) {
        if (m == 1) {
            // 相当于反转前n个元素
            reverseN(head, n);
        }
        head.next = reverseBetween(head.next, m - 1, n - 1);
        return head;
    }


    ListNode reverseIteration(ListNode head) {
        ListNode pre, cur, next;
        pre = null;
        cur = head;
        next = head;
        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    ListNode reverseIterationAB(ListNode a, ListNode b) {
        ListNode pre, cur, next;
        pre = null;
        cur = a;
        next = a;
        while (cur != b) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    /**
     * 倒序打印单链表中的元素值
     *
     * @param head
     */
    void traverse(ListNode head) {
        if (head == null) {
            return;
        }
        traverse(head.next);
        System.out.println(head.val);
    }

    boolean isPalindromic(ListNode head) {
        left = head;
        return traversePalindromic(head);
    }

    boolean traversePalindromic(ListNode right) {
        if (right == null) {
            return true;
        }
        boolean res = traversePalindromic(right.next);
        // 后序遍历代码
        res = res && (right.val == left.val);
        left = left.next;
        return res;
    }

    public static void main(String[] args) {
        Demo02 link = new Demo02();
        link.insertHeadNode(1);
        link.insertTailNode(2);
        link.insertTailNode(3);
        link.insertTailNode(3);
        link.insertTailNode(1);
        link.insertTailNode(0);
        System.out.println(link);

        System.out.println(link.isPalindromic(link.head));

        int i = 0;

//        ListNode reverse = link.reverse(link.head);
//        System.out.println(reverse);
//        ListNode reverseN = link.reverseN(link.head, 3);
//        System.out.println(reverseN);
//        ListNode listNode = link.reverseIteration(link.head.next);
//        System.out.println(listNode);
    }
}
