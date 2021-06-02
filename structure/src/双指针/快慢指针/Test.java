package 双指针.快慢指针;


/**
 * * 快慢指针：主要解决链表中的问题，比如典型的判定链表中是否包含环
 * * 快慢指针一般都初始化指向链表的头节点head，前进时快指针fast在前，慢指针slow在后，巧妙解决一些链表的问题
 * * <p>
 * * 1、判定链表中是否含有环
 * * 单链表的特点是每个节点只知道下一个节点，所以一个指针的话无法判断表中是否含有环
 * *
 *
 * @author fangsheng
 * @date 2021/5/26 10:29 上午
 */
public class Test {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.addNode(1);
        linkedList.addNode(2);
        linkedList.addNode(2);
        linkedList.addNode(3);
        linkedList.addNode(3);
        linkedList.addNode(5);
        linkedList.addNode(6);
//        linkedList.addToHead(7);
//        linkedList.printLinkedList();
        System.out.println(linkedList.hasCycle(linkedList.head));
        System.out.println(linkedList.middleNode(linkedList.head));
        System.out.println(linkedList.lastKNode(2));
    }
}
