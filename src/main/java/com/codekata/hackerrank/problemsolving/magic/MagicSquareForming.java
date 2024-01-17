package com.codekata.hackerrank.problemsolving.magic;


import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MagicSquareForming {

    //https://www.hackerrank.com/challenges/magic-square-forming/problem?isFullScreen=true

    public static void main(String[] args) throws IOException {
        /*
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        List<List<Integer>> s = new ArrayList<>();
        IntStream.range(0, 3).forEach(i -> {
            try {
                s.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
        int result = Result.formingMagicSquare(s);
        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();
        bufferedReader.close();
        bufferedWriter.close();
        */

        List<List<Integer>> s = List.of(
                List.of(5, 3, 4),
                List.of(1, 5, 8),
                List.of(6, 4, 2)); // expected output: 7

        List<List<Integer>> s1 = List.of(
                List.of(4, 8, 2),
                List.of(4, 5, 7),
                List.of(6, 1, 6)); // expected output: 4

        List<List<Integer>> s2 = List.of(
                List.of(4, 9, 2),
                List.of(3, 5, 7),
                List.of(8, 1, 5)); // expected output: 1

        List<List<Integer>> s3 = List.of(
                List.of(1, 3, 8),
                List.of(6, 4, 1),
                List.of(2, 6, 5)); // expected output: 9

        int result = Result.formingMagicSquare(s3);
        System.out.println(result);
    }
}

class Result {

    /*
     * Complete the 'formingMagicSquare' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY s as parameter.
     */
    public static int formingMagicSquare(List<List<Integer>> s) {
        int[][][] possiblePermutations = {
                {{8, 1, 6}, {3, 5, 7}, {4, 9, 2}},// 1
                {{6, 1, 8}, {7, 5, 3}, {2, 9, 4}},// 2
                {{4, 9, 2}, {3, 5, 7}, {8, 1, 6}},// 3
                {{2, 9, 4}, {7, 5, 3}, {6, 1, 8}},// 4
                {{8, 3, 4}, {1, 5, 9}, {6, 7, 2}},// 5
                {{4, 3, 8}, {9, 5, 1}, {2, 7, 6}},// 6
                {{6, 7, 2}, {1, 5, 9}, {8, 3, 4}},// 7
                {{2, 7, 6}, {9, 5, 1}, {4, 3, 8}},// 8
        };
        int minCost = Integer.MAX_VALUE;
        for (int permutation = 0; permutation < 8; permutation++) {
            int permutationCost = 0;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++)
                    permutationCost += Math.abs(s.get(i).get(j) - possiblePermutations[permutation][i][j]);
            }
            minCost = Math.min(minCost, permutationCost);
        }
        return minCost;
    }

    //This solution is in progress. It provides the occurrence, difference and sumList of sections
    public static int formingMagicSquare2(List<List<Integer>> s) {
        int magicConstant = (int) (s.size() * (Math.pow(s.size(), 2) + 1) / 2); // magic constants formula
        List<SumAnalysisModel> sumList = getSumList(s);// of row, column, diagonal
        Map<Integer, Integer> occurrences = new HashMap<>();

        for (SumAnalysisModel sum : sumList) {
            System.out.println(sum.getCoordinateList() + " " + sum.getMatrixSection() + " " + sum.getOrder() + " " + sum.getSum());
            occurrences.put(sum.getSum(), occurrences.getOrDefault(sum.getSum(), 0) + 1);
        }

        System.out.println();
        int total = 0;
        for (Map.Entry<Integer, Integer> occur : occurrences.entrySet()) {
            System.out.println(occur.getKey() + ": occurrence: " + occur.getValue() + " difference:" + (magicConstant - occur.getKey()));
            final int multiply = occur.getValue() / 2;
            if (multiply >= 2) {
                total += Math.abs(magicConstant - occur.getKey()) * multiply;
            } else {
                total += Math.abs(magicConstant - occur.getKey());
            }
        }
        System.out.println();

        return total;
    }

    private static List<SumAnalysisModel> getSumList(List<List<Integer>> s) {
        List<SumAnalysisModel> sumAnalysisModelList = new ArrayList<>();
        int columnSum = 0;
        int rowSum = 0;
        int mainDiagonalSum = 0;
        int antiDiagonalSum = 0;
        for (int i = 0; i < s.size(); i++) {
            for (int j = 0; j < s.size(); j++) {
                columnSum += s.get(j).get(i);
                rowSum += s.get(i).get(j);
            }
            sumAnalysisModelList.add(SumAnalysisConverter.convert(MatrixSection.COLUMN, i, columnSum));
            sumAnalysisModelList.add(SumAnalysisConverter.convert(MatrixSection.ROW, i, rowSum));
            columnSum = 0;
            rowSum = 0;
            mainDiagonalSum += s.get(i).get(i);
            antiDiagonalSum += s.get(i).get(s.size() - i - 1);
        }
        sumAnalysisModelList.add(SumAnalysisConverter.convert(MatrixSection.DIAGONAL, 0, mainDiagonalSum));
        sumAnalysisModelList.add(SumAnalysisConverter.convert(MatrixSection.DIAGONAL, 1, antiDiagonalSum));

        return sumAnalysisModelList;
    }
}
