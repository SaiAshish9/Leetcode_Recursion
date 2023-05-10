package com.sai.Leetcode_Recursion;

public class RemoveNodesFromLinkedList {

    public static ListNode fn(ListNode head) {
        if (head == null)
            return null;
        head.next = fn(head.next);
        return head.next != null && head.val < head.next.val ? head.next : head;
    }

    public static void main(String[] args) {
        ListNode l = new ListNode(5);
        l.next = new ListNode(2);
        l.next.next = new ListNode(13);
        l.next.next.next = new ListNode(3);
        l.next.next.next.next = new ListNode(8);
        System.out.println(fn(l)); // 13 -> 8
    }

}
