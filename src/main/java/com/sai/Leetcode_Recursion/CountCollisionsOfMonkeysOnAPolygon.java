package com.sai.Leetcode_Recursion;

public class CountCollisionsOfMonkeysOnAPolygon {
    private static final int kMod = 1_000_000_007;

    public static int monkeyMove(int n) {
        final int res = (int) myPow(2, n) - 2;
        return res < 0 ? res + kMod : res;
    }
    private static long myPow(long x, int n) {
        if (n == 0)
            return 1;
        if (n % 2 == 1)
            return x * myPow(x, n - 1) % kMod;
        return myPow(x * x % kMod, n / 2);
    }

    public static void main(String[] args) {
        System.out.println(monkeyMove(3)); // 6
        /*
There are 8 total possible movements.
Two ways such that they collide at some point are:
- Monkey 1 moves in a clockwise direction; monkey 2 moves in an anticlockwise direction;
monkey 3 moves in a clockwise direction. Monkeys 1 and 2 collide.
- Monkey 1 moves in an anticlockwise direction; monkey 2 moves in an anticlockwise direction;
monkey 3 moves in a clockwise direction. Monkeys 1 and 3 collide.
It can be shown 6 total movements result in a collision.
         */
    }

}
