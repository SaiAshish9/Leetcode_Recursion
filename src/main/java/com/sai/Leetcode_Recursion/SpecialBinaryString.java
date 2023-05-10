package com.sai.Leetcode_Recursion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SpecialBinaryString {

    public static String makeLargestSpecial(String S) {
        List<String> specials = new ArrayList<>();
        int count = 0;
        for (int i = 0, j = 0; j < S.length(); ++j) {
            count += S.charAt(j) == '1' ? 1 : -1;
            if (count == 0) {
                specials.add("1" + makeLargestSpecial(S.substring(i + 1, j)) + "0");
                i = j + 1;
            }
        }
        Collections.sort(specials, Collections.reverseOrder());
        return String.join("", specials);
    } // 11100100

    public static void main(String[] args) {
        System.out.println(makeLargestSpecial("11011000"));
    }

}



