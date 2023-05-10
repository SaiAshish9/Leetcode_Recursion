package com.sai.Leetcode_Recursion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParseLispExpression {

    public static int evaluate(String expression) {
        return eval(expression, new HashMap<>());
    }

    private static int eval(String expression, Map<String, Integer> map) {
        List<String> strs = parse(expression.substring(1, expression.length() - 1));
        if(strs.get(0).equals("add")) {
            return cal(strs.get(1), map) + cal(strs.get(2), map);
        } else if(strs.get(0).equals("mult")) {
            return cal(strs.get(1), map) * cal(strs.get(2), map);
        } else {
            Map<String, Integer> next = new HashMap<>(map);
            for(int i = 1; i < strs.size() - 1; i += 2) {
                next.put(strs.get(i), cal(strs.get(i + 1), next));
            }
            return cal(strs.get(strs.size() - 1), next);
        }
    }

    private static int cal(String s, Map<String, Integer> map) {
        if(s.charAt(0) == '(') {
            return eval(s, map);
        } else if(map.containsKey(s)) {
            return map.get(s);
        } else {
            return Integer.valueOf(s);
        }
    }

    private static List<String> parse(String s) {
        int par = 0, start = 0;
        List<String> list = new ArrayList<>();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == ' ' && par == 0) {
                list.add(s.substring(start, i));
                start = i + 1;
            } else if(c == '(') {
                par++;
            } else if(c == ')') {
                par--;
            }
        }
        list.add(s.substring(start));
        return list;
    }

    public static void main(String[] args) {
        System.out.println(evaluate("(let x 3 x 2 x)")); // 2
    }

}
