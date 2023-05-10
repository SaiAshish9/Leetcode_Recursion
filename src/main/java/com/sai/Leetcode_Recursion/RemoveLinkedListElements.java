package com.sai.Leetcode_Recursion;

public class RemoveLinkedListElements {

    public static ListNode fn(ListNode head, int val) {
        if (head == null) return null;
        head.next = fn(head.next, val);
        return head.val == val ? head.next : head;
    }

    public static void main(String[] args) {
        ListNode l = new ListNode(1);
        l.next = new ListNode(2);
        l.next.next = new ListNode(3);
        l.next.next.next = new ListNode(6);
        l.next.next.next.next = new ListNode(4);
        l.next.next.next.next.next = new ListNode(5);
        l.next.next.next.next.next.next = new ListNode(6);
        System.out.println(fn(l, 6)); // [1,2,3,4,5]
    }

}
