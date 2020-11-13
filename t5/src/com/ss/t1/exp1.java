package com.ss.t1;

import java.util.List;

public class exp1 {

    class ListNode {
        int val;
        ListNode next;
    }

//    void traver(ListNode head) {
//        for (ListNode p = head; p != null; p = p.next){
//
//        }
//    }

    void traver(ListNode head) {
        traver(head.next);
    }
}
