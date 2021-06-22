package 链表;

/**
 * @author fangsheng
 * @date 2021/6/15 10:10 上午
 */
public class T1 {
    public static void main(String[] args) {
        MyLinkedList linkedList = new MyLinkedList();
        linkedList.addNode(1);
        linkedList.addNode(2);
        linkedList.addNode(3);
        linkedList.addNode(4);
        linkedList.addNode(5);
        linkedList.addNode(6);
        ListNode reverse = linkedList.reverseList(linkedList.head);
//        ListNode reverseBetween2 = linkedList.reverseBetween2(linkedList.head, 1, 4);
//        ListNode reverseN2 = linkedList.reverseN2(linkedList.head, 2);
//        ListNode reverseKGroup = linkedList.reverseKGroup(linkedList.head, 2);
        System.out.println(reverse);
//        System.out.println(reverseBetween2);
//        System.out.println(reverseN2);
//        System.out.println(reverseKGroup);
    }
}
