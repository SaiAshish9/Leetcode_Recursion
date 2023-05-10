package com.sai.Leetcode_Recursion;

public class AddTwoNumbers {

    static ListNode fn(ListNode l1, ListNode l2, int carry) {
        if (l1 == null && l2 == null)
            return carry != 0 ? new ListNode(carry) : null;
        int sum = carry;
        if (l1 != null) sum += l1.val;
        if (l2 != null) sum += l2.val;
        ListNode l3 = new ListNode(sum % 10);
        carry = sum / 10;
        l3.next = fn(l1 != null ? l1.next : null, l2 != null ? l2.next : null, carry);
        return l3;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        System.out.println(fn(l1, l2, 0));
//        7 0 8
    }

}



