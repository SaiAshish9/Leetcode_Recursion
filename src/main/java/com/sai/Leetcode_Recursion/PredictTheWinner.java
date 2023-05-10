package com.sai.Leetcode_Recursion;

public class PredictTheWinner {

    public static boolean PredictTheWinner(int[] nums) {
        return dfs(0, nums.length - 1, 0, nums, true) >= 0;
    }

    public static int dfs(int start, int end, int p1, int[] nums, boolean p1Turn) {
        if (start == end)
            return p1;
        if (p1Turn) {
            int bottom = dfs(start + 1, end, p1 + nums[start], nums, false);
            int top = dfs(start, end - 1, p1 + nums[end], nums, false);
            return Math.max(top, bottom);
        } else {
            int bottom = dfs(start + 1, end, p1 - nums[start], nums, true);
            int top = dfs(start, end - 1, p1 - nums[end], nums, true);
            return Math.min(bottom, top);
        }
    }

    public static void main(String[] args) {
        System.out.println(PredictTheWinner(new int[]{1, 5, 2})); // false
    }

}



