package com.sai.Leetcode_Recursion;

import java.util.ArrayList;
import java.util.List;

public class OutputContestMatches {

    public static String findContestMatch(int n) {
        List<String> matches = new ArrayList<>();
        for (int i = 1; i <= n; ++i)
            matches.add(String.valueOf(i));
        return fn(matches);
    }

    private static String fn(List<String> matches) {
        if (matches.size() == 1)
            return matches.get(0);
        List<String> nextMatches = new ArrayList<>();
        for (int i = 0; i < matches.size() / 2; ++i)
            nextMatches.add("(" + matches.get(i) + "," + matches.get(matches.size() - 1 - i) + ")");
        return fn(nextMatches);
    }

    public static void main(String[] args) {
        System.out.println(findContestMatch(3)); // (1,3)
    }

}


