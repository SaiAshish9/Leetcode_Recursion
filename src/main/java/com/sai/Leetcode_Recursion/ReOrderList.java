package com.sai.Leetcode_Recursion;

public class ReOrderList {

    private static boolean isStop;
    private static ListNode temp;

    public static void reorderList(ListNode head) {
        temp = head;
        isStop = false;
        reorder(head);
    }

    private static void reorder(ListNode head) {
        if (head == null) return;
        reorder(head.next);
        if (!isStop) {
            ListNode next = temp.next;
            temp.next = head;
            head.next = next;
            temp = next;
        }
        if (temp != null && temp.next == head) {
            temp.next = null;
            isStop = true;
        }
    }


    public static void main(String[] args) {
        ListNode l = new ListNode(1);
        l.next = new ListNode(2);
        l.next.next = new ListNode(3);
        l.next.next.next = new ListNode(4);
        reorderList(l); // [1,4,2,3]
        System.out.println(l);
    }

}


