package com.sai.Leetcode_Recursion;

public class MergeTwoSortedLists {

    public static ListNode fn(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        else if (l2 == null) return l1;
        else if (l1.val <= l2.val) {
            l1.next = fn(l1.next, l2);
            return l1;
        } else {
            l2.next = fn(l1, l2.next);
            return l2;
        }
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);
        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);
        System.out.println(fn(l1, l2)); // 1 1 2 3 4 4
    }

}



