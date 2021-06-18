package 链表;

import java.util.List;

/**
 * @author fangsheng
 * @date 2021/6/15 10:26 上午
 */
public class MyLinkedList {

    ListNode head = null;

    public void addNode(int d) {
        ListNode newNode = new ListNode(d);
        if (head == null) {
            head = newNode;
            return;
        }
        ListNode tmp = head;
        while (tmp.next != null) {
            tmp = tmp.next;
        }
        tmp.next = newNode;
    }

    ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode last = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }

    /**
     * 后驱节点
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

    ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == 1) {
            return reverseN(head, right);
        }
        head.next = reverseBetween(head.next, left - 1, right - 1);
        return head;
    }

    /**
     * 如果是的话，我觉得这样改是不符合题解的意思的。因为结合文章图片中「从第二个链表变成第三个链表的过程」，
     * removed是值为4的节点，我理解题解中头插法的意思是要把 removed 从 p 的后面删除，
     * 然后插在 g 的紧后面。如果改成 removed.next = p;的话，那值为3的节点就没了。（如果有理解不对的地方不好意思）
     * @param head
     * @param m
     * @param n
     * @return
     */

    ListNode reverseBetween2(ListNode head, int m, int n) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode g = dummyHead;
        ListNode p = dummyHead.next;
        for (int i = 0; i < m - 1; i++) {
            g = g.next;
            p = p.next;
        }
        for (int i = 0; i < n - m; i++) {
            ListNode removed = p.next;
            p.next = p.next.next;
            removed.next = g.next;
            g.next = removed;
        }
        return dummyHead.next;
    }

    @Override
    public String toString() {
        return "MyLinkedList{" +
                "head=" + head +
                '}';
    }
}
