package com.codekata.hackerrank.problemsolving.icpc;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;


public class ProgrammingContest {

    //https://www.hackerrank.com/challenges/acm-icpc-team/problem?isFullScreen=true

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
        int n = Integer.parseInt(firstMultipleInput[0]);
        int m = Integer.parseInt(firstMultipleInput[1]);
        List<String> topic = IntStream.range(0, n).mapToObj(i -> {
            try {
                return bufferedReader.readLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }).collect(toList());
        List<Integer> result = Result.acmTeam(topic);
        /*
        bufferedWriter.write(
                result.stream()
                        .map(Object::toString)
                        .collect(joining("\n"))
                        + "\n"
        );
        bufferedWriter.close();
        */
        bufferedReader.close();
        System.out.println(result);
    }
}

class Result {

    /*
     * Complete the 'acmTeam' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts STRING_ARRAY topic as parameter.
     */
    public static List<Integer> acmTeam(List<String> topic) {
        List<List<Integer>> indexOfTopics = getIndexOfTopics(topic);
        int highest = 0;
        int count = 0;
        Set<Integer> combinedTopics = new HashSet<>();
        List<Integer> twoPairs = new ArrayList<>();
        for (int i = 0; i < indexOfTopics.size() - 1; i++) {
            combinedTopics.clear();
            combinedTopics.addAll(indexOfTopics.get(i));
            for (int j = i + 1; j < indexOfTopics.size(); j++) {
                if (i != j) {
                    combinedTopics.addAll(indexOfTopics.get(j));
                    //System.out.println( i+1 + " - " + (j+1) + " = " + combinedTopics.size());
                    twoPairs.add(combinedTopics.size());
                    highest = Math.max(highest, combinedTopics.size());
                    combinedTopics.clear();
                    combinedTopics.addAll(indexOfTopics.get(i));
                }
            }
        }
        List<Integer> results = new ArrayList<>();
        results.add(highest);

        for (Integer twoPair : twoPairs) {
            if (highest == twoPair) {
                count++;
            }
        }
        results.add(count);

        return results;
    }

    private static List<List<Integer>> getIndexOfTopics(List<String> topic) {
        List<List<Integer>> results = new ArrayList<>();
        for (String value : topic) {
            List<Integer> pair = new ArrayList<>();
            final String s = value;
            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(j) == '1') {
                    pair.add(j + 1);
                }
            }
            results.add(pair);
        }

        return results;
    }

}