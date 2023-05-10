package com.sai.Leetcode_Recursion;

public class ReverseNodesInkGroup {

    public static ListNode fn(ListNode head, int k) {
        if(k == 1) return head;
        ListNode curr = head;
        for(int i = 0 ; i < k ; i ++) {
            if(head != null) {
                head = head.next;
            }else {
                return curr;
            }
        }
        ListNode next = fn(head,k);
        ListNode tail = curr;
        ListNode prev = curr;
        ListNode tempNext;
        for(int i = 0 ; i < k ; i ++) {
            tempNext = curr.next;
            curr.next = prev;
            prev = curr;
            curr = tempNext;
        }
        tail.next = next;
        return prev;
    }

    public static void main(String[] args) {
        ListNode l = new ListNode(1);
        l.next = new ListNode(2);
        l.next.next = new ListNode(3);
        l.next.next.next = new ListNode(4);
        l.next.next.next.next = new ListNode(5);
        System.out.println(fn(l,2)); // [2,1,4,3,5]
    }

}



