package 双指针.快慢指针;


import java.util.Arrays;
import java.util.List;

/**
 * 快慢指针：主要解决链表中的问题，比如典型的判定链表中是否包含环
 * 快慢指针一般都初始化指向链表的头节点head，前进时快指针fast在前，慢指针slow在后，巧妙解决一些链表的问题
 * <p>
 * 1、判定链表中是否含有环
 * 单链表的特点是每个节点只知道下一个节点，所以一个指针的话无法判断表中是否含有环
 *
 * @author fangsheng
 * @date 2021/5/26 10:30 上午
 */
public class LinkedList {
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

    public void addToHead(int n) {
        ListNode node = new ListNode(n);
        ListNode tmp = head;
        while (tmp.next != null) {
            tmp = tmp.next;
        }
        tmp.next = node;
        node.next = head;
    }

    public void printLinkedList() {
        ListNode tmp = head;
        while (tmp != null) {
            System.out.println(tmp.val + " ");
            tmp = tmp.next;
        }
        System.out.println();
    }

    /**
     * 链表是否含有环
     *
     * @param head
     * @return
     */
    boolean hasCycle(ListNode head) {
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

    /**
     * 寻找链表中点的一个重要作用是对链表进行归并排序
     * 回想数组的归并排序：求中点索引递归地把数组二分，最后合并两个有序数组。对于链表，合并两个有序链表是很简单的，难点就在于二分。
     *
     * @param head
     * @return
     */
    ListNode middleNode(ListNode head) {
        ListNode fast, slow;
        fast = slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    /**
     * 让快指针先走 k 步，然后快慢指针开始同速前进。这样当快指针走到链表末尾 null 时，慢指针所在的位置就是倒数第 k 个链表节点
     *
     * @param k
     * @return
     */
    ListNode lastKNode(int k) {
        ListNode slow, fast;
        slow = fast = head;
        while (k-- > 0) {
            fast = fast.next;
        }
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

}
