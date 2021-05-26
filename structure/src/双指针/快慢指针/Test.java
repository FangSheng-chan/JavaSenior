package 双指针.快慢指针;


/**
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
