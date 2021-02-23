package t11;

/**
 * @author fangsheng
 * @date 2021/2/22 上午9:51
 */
public class Demo01 {

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            this.val = x;
        }

        ListNode reverse(ListNode head) {
            if (head.next == null) {
                return head;
            }
            ListNode last = reverse(head.next);
            head.next.next = head;
            head.next = null;
            head.next = null;
            return last;
        }
    }


}
