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
//        ListNode reverse = linkedList.reverse(linkedList.head);
        ListNode reverseN = linkedList.reverseBetween2(linkedList.head, 2, 4);
//        System.out.println(reverse);
        System.out.println(reverseN);
    }
}
