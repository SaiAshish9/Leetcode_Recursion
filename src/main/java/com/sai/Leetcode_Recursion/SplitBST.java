package com.sai.Leetcode_Recursion;

public class SplitBST {

    public static TreeNode[] splitBST(TreeNode root, int target) {
        if (root == null)
            return new TreeNode[] {null, null};
        if (root.val > target) {
            TreeNode[] res = splitBST(root.left, target);
            root.left = res[1];
            return new TreeNode[] {res[0], root};
        } else {
            TreeNode[] res = splitBST(root.right, target);
            root.right = res[0];
            return new TreeNode[] {root, res[1]};
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        System.out.println(splitBST(root, 2)); // 1 <- 2 , 3
    }

}
