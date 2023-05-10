package com.sai.Leetcode_Recursion;

public class VerifyPreorderSequenceInBinarySearchTree {

    private static int i = 0;

    public static boolean verifyPreorder(int[] preorder) {
        dfs(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE);
        return i == preorder.length;
    }

    private static void dfs(int[] preorder, int min, int max) {
        if (i == preorder.length)
            return;
        if (preorder[i] < min || preorder[i] > max)
            return;
        final int val = preorder[i++];
        dfs(preorder, min, val);
        dfs(preorder, val, max);
    }

    public static void main(String[] args) {
        System.out.println(verifyPreorder(new int[]{5, 2, 6, 1, 3})); // false
    }

}


