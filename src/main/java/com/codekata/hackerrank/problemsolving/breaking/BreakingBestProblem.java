package com.codekata.hackerrank.problemsolving.breaking;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BreakingBestProblem {

    //https://www.hackerrank.com/challenges/breaking-best-and-worst-records/problem?isFullScreen=true

    public static void main(String[] args) throws IOException {
        /*
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        int n = Integer.parseInt(bufferedReader.readLine().trim());
        List<Integer> scores = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());
        List<Integer> result = Result.breakingRecords(scores);
        bufferedWriter.write(
                result.stream()
                        .map(Object::toString)
                        .collect(joining(" "))
                        + "\n"
        );
        bufferedReader.close();
        bufferedWriter.close();
         */

        //List<Integer> scores = Arrays.asList(10, 5, 20, 20, 4, 5, 2, 25, 1); //2,4
        List<Integer> scores = Arrays.asList(3, 4, 21, 36, 10, 28, 35, 5, 24, 42); //4,0
        //List<Integer> result = Result.breakingRecords(scores);
        List<Integer> result = Result.breakingRecordsImproved(scores);
        System.out.println(result);


    }
}

class Result {

    /*
     * Complete the 'breakingRecords' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY scores as parameter.
     */
    public static List<Integer> breakingRecords(List<Integer> scores) {
        List<Integer> bestAndWorst = new ArrayList<>();
        int initialBest = scores.get(0);
        int initialWorst = scores.get(0);
        int countBest = 0;
        int countWorst = 0;
        for (int i = 1; i < scores.size(); i++) {
            if (scores.get(i) > initialBest) {
                countBest++;
                initialBest = scores.get(i);
            }
            if (scores.get(i) < initialWorst) {
                countWorst++;
                initialWorst = scores.get(i);
            }
        }
        bestAndWorst.add(countBest);
        bestAndWorst.add(countWorst);

        return bestAndWorst;
    }

    public static List<Integer> breakingRecordsImproved(List<Integer> scores) { //Improved Version
        int initialBest = scores.get(0), initialWorst = scores.get(0), countBest = 0, countWorst = 0;
        for (int score : scores) {
            if (score > initialBest) {
                countBest++;
                initialBest = score;
            }
            if (score < initialWorst) {
                countWorst++;
                initialWorst = score;
            }
        }

        return List.of(countBest, countWorst);
    }

}




