package com.codekata.hackerrank.problemsolving.lane;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ServiceLane {

    //https://www.hackerrank.com/challenges/service-lane/problem?isFullScreen=true

    public static void main(String[] args) throws IOException {
        /*
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
        int n = Integer.parseInt(firstMultipleInput[0]);
        int t = Integer.parseInt(firstMultipleInput[1]);
        List<Integer> width = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());
        List<List<Integer>> cases = new ArrayList<>();
        IntStream.range(0, t).forEach(i -> {
            try {
                cases.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
        List<Integer> result = Result.serviceLane(width, cases);
        System.out.println(result);

//        bufferedWriter.write(
//                result.stream()
//                        .map(Object::toString)
//                        .collect(joining("\n"))
//                        + "\n"
//        );
//        bufferedWriter.close();

        bufferedReader.close();
        */

        List<Integer> width = Arrays.asList(2, 3, 1, 2, 3, 2, 3, 3);
        List<List<Integer>> cases = Arrays.asList(
                Arrays.asList(0, 3 ),
                Arrays.asList(4, 6 ),
                Arrays.asList(6, 7 ),
                Arrays.asList(3, 5 ),
                Arrays.asList(0, 7 )); //expected output : 1, 2, 3, 2, 1
        List<Integer> result = Result.serviceLane(width, cases); //
        System.out.println(result);

    }
}


class Result {

    /*
     * Complete the 'serviceLane' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. 2D_INTEGER_ARRAY cases
     */
    public static List<Integer> serviceLane(List<Integer> width, List<List<Integer>> cases) {
        List<Integer>  result = new ArrayList<>();
        for (List<Integer> aCase : cases) {
            final Integer start = aCase.get(0);
            final Integer end = aCase.get(1);

            int highest = Integer.MAX_VALUE;
            for (int j = start; j <= end; j++) {
                highest = Math.min(highest, width.get(j));
            }
            result.add(highest);
        }

        return result;
    }
}
