package com.codekata.hackerrank.problemsolving.powersum;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class PowerSum {

    //https://www.hackerrank.com/challenges/the-power-sum/problem?isFullScreen=true

    public static void main(String[] args) throws IOException {
        /*
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        int X = Integer.parseInt(bufferedReader.readLine().trim());
        int N = Integer.parseInt(bufferedReader.readLine().trim());
        int result = Result.powerSum(X, N);
        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();
        bufferedReader.close();
        bufferedWriter.close();
                 */
        //int X = 10, N = 2; //expected output: 1
        int X = 100, N = 2; //expected output: 3
        int result = Result.powerSum(X, N);
        System.out.println(result);
    }
}


class Result {

    /*
     * Complete the 'powerSum' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER X
     *  2. INTEGER N
     */
    public static int powerSum(int X, int N) {
        Set<List<Integer>> possiblePowers = new HashSet<>();
        final int range = X / 10;

        for (int i = 0; i < range; i++) {
            generatePowerCombinations(possiblePowers, new ArrayList<>(), i, N, X);
        }

        for (List<Integer> pairList : possiblePowers) {
            pairList.removeIf(element -> element == 0);
        }

        Set<List<Integer>> removedDuplicates = new HashSet<>(possiblePowers);

        //printing the combinations
        for (List<Integer> pairList : removedDuplicates) {
            System.out.println(pairList);
        }

        return removedDuplicates.size();
    }

    private static void generatePowerCombinations(Set<List<Integer>> possiblePowers, List<Integer> currentList, int currentNumber, int power, int targetSum) {
        currentList.add(currentNumber);

        //initial value is calculated
        int currentSum = calculatePowerSum(currentList, power);

        if (currentSum == targetSum) {
            possiblePowers.add(new ArrayList<>(currentList));
        } else if (currentSum < targetSum) {
            for (int i = currentNumber + 1; i < targetSum; i++) {
                //Recursively find combination based on target sum
                generatePowerCombinations(possiblePowers, currentList, i, power, targetSum);
            }
        }

        currentList.remove(currentList.size() - 1);
    }

    private static int calculatePowerSum(List<Integer> list, int power) {
        int sum = 0;
        for (int num : list) {
            sum += Math.pow(num, power);
        }
        return sum;
    }
}


