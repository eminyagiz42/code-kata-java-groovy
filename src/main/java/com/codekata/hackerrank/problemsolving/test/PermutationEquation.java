package com.codekata.hackerrank.problemsolving.test;


import java.io.IOException;
import java.util.*;


public class PermutationEquation {

    //https://www.hackerrank.com/challenges/permutation-equation/problem?isFullScreen=true

    public static void main(String[] args) throws IOException {
        /*
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        int n = Integer.parseInt(bufferedReader.readLine().trim());
        String[] pTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
        List<Integer> p = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int pItem = Integer.parseInt(pTemp[i]);
            p.add(pItem);
        }
        List<Integer> result = Result.permutationEquation(p);
        for (int i = 0; i < result.size(); i++) {
            System.out.print(String.valueOf(result.get(i)));
            //bufferedWriter.write(String.valueOf(result.get(i)));

            if (i != result.size() - 1) {
                System.out.print("\n");
                //bufferedWriter.write("\n");
            }
        }
        //bufferedWriter.newLine();
        bufferedReader.close();
        //bufferedWriter.close();
        */
        //List<Integer> p = Arrays.asList(2, 3, 1); // 3,1,2 --> p(2), p(3), p(1) --> 2,3,1
        List<Integer> p = Arrays.asList(4, 3, 5, 1, 2); // 1,5,2,4,3  ---> p(4), p(2), p(3), p(1), p(5)  --> 1,3,5,4,2
        List<Integer> result = Result.permutationEquation(p);
        System.out.println(result);
    }
}


class Result {

    /*
     * Complete the 'permutationEquation' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY p as parameter.
     */
    public static List<Integer> permutationEquation(List<Integer> p) {
        Map<Integer, Integer> integerMap = new HashMap<>();
        List<Integer> results = new ArrayList<>();

        for (int i = 0; i < p.size(); i++) {
            integerMap.put(p.get(i), i + 1);
        }

        for (int i = 1; i <= p.size(); i++) {
            results.add(integerMap.get(integerMap.get(i)));
        }

        return results;
    }
}