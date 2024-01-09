package com.codekata.leetcode.interview75.second25;


import java.util.List;

import com.google.common.collect.Lists;

import java.util.*;


public class EvaluateDivision {

    public static void main(String[] args) {

        // https://leetcode.com/problems/evaluate-division

        double[] values = {2.0, 3.0};
        final double[] doubles = calcEquation(getListList1(), values, getListList2());
        for (double aDouble : doubles) {
            System.out.println("aDouble = " + aDouble);
        }
    }

    public static double[] calcEquation(List<List<String>> equations, double[] values,
                                        List<List<String>> queries) {
        double[] ans = new double[queries.size()];
        Map<String, Map<String, Double>> graph = new HashMap<>();

        for (int i = 0; i < equations.size(); ++i) {
            final String A = equations.get(i).get(0);
            final String B = equations.get(i).get(1);
            graph.putIfAbsent(A, new HashMap<>());
            graph.putIfAbsent(B, new HashMap<>());
            graph.get(A).put(B, values[i]);
            graph.get(B).put(A, 1.0 / values[i]);
        }

        for (int i = 0; i < queries.size(); ++i) {
            final String A = queries.get(i).get(0);
            final String C = queries.get(i).get(1);
            if (!graph.containsKey(A) || !graph.containsKey(C))
                ans[i] = -1.0;
            else
                ans[i] = divide(graph, A, C, new HashSet<>());
        }
        return ans;
    }


    private static double divide(Map<String, Map<String, Double>> graph, final String A, final String C,
                                 Set<String> seen) {
        if (A.equals(C)) {
            return 1.0;
        }
        seen.add(A);
        for (final String B : graph.get(A).keySet()) {
            if (seen.contains(B)) {
                continue;
            }
            final double res = divide(graph, B, C, seen);
            if (res > 0) {
                return graph.get(A).get(B) * res;
            }
        }
        return -1.0;
    }

    private static List<List<String>> getListList1() {
        List<String> eq1 = Lists.newArrayList("a", "b");
        List<String> eq2 = Lists.newArrayList("b", "c");
        List<List<String>> eq = new ArrayList<>();
        eq.add(eq1);
        eq.add(eq2);
        return eq;
    }

    private static List<List<String>> getListList2() {
        List<String> query1 = Lists.newArrayList("a", "c");
        List<String> query2 = Lists.newArrayList("b", "a");
        List<String> query3 = Lists.newArrayList("a", "e");
        List<String> query4 = Lists.newArrayList("a", "a");
        List<String> query5 = Lists.newArrayList("x", "x");
        List<List<String>> queries = new ArrayList<>();
        queries.add(query1);
        queries.add(query2);
        queries.add(query3);
        queries.add(query4);
        queries.add(query5);
        return queries;
    }
}