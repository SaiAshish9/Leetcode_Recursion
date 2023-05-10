package com.sai.Leetcode_Recursion;

public class PrintImmutableLinkedListInReverse {

    interface ImmutableListNode {
        void printValue();

        ImmutableListNode getNext();
    }

    void printLinkedListInReverse(ImmutableListNode head) {
        if (head == null)
            return;
        printLinkedListInReverse(head.getNext());
        head.printValue();
    }

    public static void main(String[] args) {
    }

}
