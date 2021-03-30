package s4;

/**
 * @author fangsheng
 * @date 2021/3/8 上午11:18
 */
public class DoubleList {
    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addNode(1);
        myLinkedList.addNode(2);
        myLinkedList.addNode(2);
        myLinkedList.addNode(3);
//        myLinkedList.addNode(3);
//        myLinkedList.addNode(5);
//        myLinkedList.addNode(5);
//        myLinkedList.addNode(6);

        ListNode listNode = myLinkedList.deleteDuplicates(myLinkedList.head);
        System.out.println(listNode);
//        ListNode listNode = myLinkedList.removeNthFromEnd(myLinkedList.head, 3);
//        System.out.println(listNode);
//        char[] chars = {'1', '2', '3', '4'};
//        myLinkedList.reverseString(chars);
//        System.out.println(chars);
    }


    /**
     * 如果链表含有环，那么这个指针就会陷入死循环
     *
     * @param head
     * @return
     */
    boolean hasCycle(ListNode head) {
        while (head != null) {
            head = head.next;
        }
        return false;
    }

    boolean hasCycle2(ListNode head) {
        ListNode fast, slow;
        fast = slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow) {
                return true;
            }
        }
        return false;
    }

    ListNode detectCycle(ListNode head) {
        ListNode fast, slow;
        fast = slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                break;
            }
        }
        if (fast == null || fast.next == null) {
            return null;
        }
        slow = head;
        while (slow != fast) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

    static void reverseString(char[] arr) {
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }

}
