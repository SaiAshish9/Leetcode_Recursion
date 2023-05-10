package com.sai.Leetcode_Recursion;

public class SwapNodesInPairs {

    public static ListNode fn(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode p = head, q = head.next, r = head.next.next;
        q.next = p;
        p.next = fn(r);
        return q;
    }

    public static void main(String[] args) {
        ListNode l = new ListNode(1);
        l.next = new ListNode(2);
        l.next.next = new ListNode(3);
        l.next.next.next = new ListNode(4);
        System.out.println(fn(l)); // 2 -> 1 -> 4 -> 3
    }

}



