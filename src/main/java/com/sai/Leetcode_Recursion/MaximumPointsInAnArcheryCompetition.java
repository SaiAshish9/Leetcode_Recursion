package com.sai.Leetcode_Recursion;

public class MaximumPointsInAnArcheryCompetition {

    static int bobPoint = 0;
    static int[] maxbob = new int[12];

    public static int[] maximumBobPoints(int numArrows, int[] aliceArrows) {
        int[] bob = new int[12];
        fn(aliceArrows, bob, 11, numArrows, 0);  //Start with max point that is 11
        return maxbob;
    }

    public static void fn(int[] alice, int[] bob, int index, int remainArr, int point) {
        if (index < 0 || remainArr <= 0) {
            if (remainArr > 0)
                bob[0] += remainArr;
            if (point > bobPoint) {
                bobPoint = point;
                maxbob = bob.clone();
            }
            return;
        }
        if (remainArr >= alice[index] + 1) {
            bob[index] = alice[index] + 1;
            fn(alice, bob, index - 1, remainArr - (alice[index] + 1), point + index);
            bob[index] = 0;
        }
        fn(alice, bob, index - 1, remainArr, point);
        bob[index] = 0;
    }

    public static void main(String[] args) {
        System.out.println(maximumBobPoints(3, new int[]{0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 2}));
//        [0,0,0,0,0,0,0,0,1,1,1,0]
    }

}
