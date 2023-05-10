package com.sai.Leetcode_Recursion;

public class ReverseLinkedList {

    static ListNode fn(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode newHead = fn(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    static ListNode reverseList(ListNode head) {
        return fn(head);
    }

    public static void main(String[] args) {
        ListNode l = new ListNode(1);
        l.next = new ListNode(2);
        l = reverseList(l); // 2 -> 1
        System.out.println(l.val);
    }

}




