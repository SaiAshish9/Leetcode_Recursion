package com.sai.Leetcode_Recursion;

import java.util.*;

public class BasicCalculatorIV {

    private static class Term implements Comparable<Term> {
        List<String> vars;
        static final Term C = new Term(Arrays.asList()); // this is the term for pure numbers

        Term(List<String> vars) {
            this.vars = vars;
        }

        public int hashCode() {
            return vars.hashCode();
        }

        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (!(obj instanceof Term)) return false;
            Term other = (Term) obj;
            return this.vars.equals(other.vars);
        }

        public String toString() {
            return String.join("*", vars);
        }

        public int compareTo(Term other) {
            if (this.vars.size() != other.vars.size()) {
                return Integer.compare(other.vars.size(), this.vars.size());
            } else {
                for (int i = 0; i < this.vars.size(); i++) {
                    int cmp = this.vars.get(i).compareTo(other.vars.get(i));
                    if (cmp != 0) return cmp;
                }
            }

            return 0;
        }
    }

    private static class Expression {
        Map<Term, Integer> terms;

        Expression(Term term, int coeff) {
            terms = new HashMap<>();
            terms.put(term, coeff);
        }

        void addTerm(Term term, int coeff) {
            terms.put(term, coeff + terms.getOrDefault(term, 0));
        }
    }

    private Term merge(Term term1, Term term2) {
        List<String> vars = new ArrayList<>();
        vars.addAll(term1.vars);
        vars.addAll(term2.vars);
        Collections.sort(vars);
        return new Term(vars);
    }

    private Expression add(Expression expression1, Expression expression2, int sign) {
        for (Map.Entry<Term, Integer> e : expression2.terms.entrySet()) {
            expression1.addTerm(e.getKey(), sign * e.getValue());
        }

        return expression1;
    }

    private Expression mult(Expression expression1, Expression expression2) {
        Expression res = new Expression(Term.C, 0);
        for (Map.Entry<Term, Integer> e1 : expression1.terms.entrySet()) {
            for (Map.Entry<Term, Integer> e2 : expression2.terms.entrySet()) {
                res.addTerm(merge(e1.getKey(), e2.getKey()), e1.getValue() * e2.getValue());
            }
        }
        return res;
    }

    private Expression calculate(String s, Map<String, Integer> map) {
        Expression l1 = new Expression(Term.C, 0);
        int o1 = 1;
        Expression l2 = new Expression(Term.C, 1);
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                int num = c - '0';
                while (i + 1 < s.length() && Character.isDigit(s.charAt(i + 1))) {
                    num = num * 10 + (s.charAt(++i) - '0');
                }
                l2 = mult(l2, new Expression(Term.C, num));
            } else if (Character.isLowerCase(c)) {
                int j = i;
                while (i + 1 < s.length() && Character.isLowerCase(s.charAt(i + 1))) i++;
                String var = s.substring(j, i + 1);
                Term term = map.containsKey(var) ? Term.C : new Term(Arrays.asList(var));
                int num = map.getOrDefault(var, 1);
                l2 = mult(l2, new Expression(term, num));
            } else if (c == '(') {
                int j = i;
                for (int cnt = 0; i < s.length(); i++) {
                    if (s.charAt(i) == '(') cnt++;
                    if (s.charAt(i) == ')') cnt--;
                    if (cnt == 0) break;
                }
                l2 = mult(l2, calculate(s.substring(j + 1, i), map));
            } else if (c == '+' || c == '-') {
                l1 = add(l1, l2, o1);
                o1 = (c == '+' ? 1 : -1);
                l2 = new Expression(Term.C, 1);
            }
        }
        return add(l1, l2, o1);
    }

    private List<String> format(Expression expression) {
        List<Term> terms = new ArrayList<>(expression.terms.keySet());
        Collections.sort(terms);
        List<String> res = new ArrayList<>(terms.size());
        for (Term term : terms) {
            int coeff = expression.terms.get(term);
            if (coeff == 0) continue;
            res.add(coeff + (term.equals(Term.C) ? "" : "*" + term.toString()));
        }
        return res;
    }

    public List<String> basicCalculatorIV(String expression, String[] evalvars, int[] evalints) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < evalvars.length; i++) {
            map.put(evalvars[i], evalints[i]);
        }
        return format(calculate(expression, map));
    }


    public static void main(String[] args) {
        System.out.println(new BasicCalculatorIV().basicCalculatorIV("e + 8 - a + 5", new String[]{"e"}, new int[]{1}));
//        ["-1*a","14"]
    }

}
