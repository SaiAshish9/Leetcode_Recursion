package com.sai.Leetcode_Recursion;

import java.util.ArrayList;
import java.util.List;

public class AllPossibleFullBinaryTrees {

    public static List<TreeNode> fn(int n) {
        if (n == 1) {
            ArrayList<TreeNode> leaf = new ArrayList();
            leaf.add(new TreeNode(0));
            return leaf;
        }
        List<TreeNode> ans = new ArrayList();
        for (int i = 1; i < n; i += 2) {
            List<TreeNode> left = fn(i);
            List<TreeNode> right = fn(n - i - 1);
            for (TreeNode l : left) {
                for (TreeNode r : right) {
                    TreeNode root = new TreeNode(0);
                    root.left = l;
                    root.right = r;
                    ans.add(root);
                }
            }
        }
        return ans;
    }

    public static List<TreeNode> allPossibleFBT(int n) {
        return fn(n);
    }

    public static void main(String[] args) {
        System.out.println(allPossibleFBT(3)); // [ 0 <- 0 -> 0]
    }

}
