package com.sai.Leetcode_Recursion;

public class PalindromeLinkedList {

    static ListNode left;
    
    public static boolean isPalindrome(ListNode head) {
        left = head;
        return fn(head);
    }

    private static boolean fn(ListNode right){
        if(right == null) return true;
        boolean res = fn(right.next);
        res = res && (right.val == left.val);
        left = left.next;
        return res;
    }

    public static void main(String[] args) {
        ListNode l = new ListNode(1);
        l.next = new ListNode(2);
        l.next.next = new ListNode(1);
        System.out.println(isPalindrome(l)); // true
    }

}


