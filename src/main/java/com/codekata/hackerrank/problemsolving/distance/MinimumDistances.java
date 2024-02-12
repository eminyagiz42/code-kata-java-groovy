package com.codekata.hackerrank.problemsolving.distance;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;


public class MinimumDistances {

    //https://www.hackerrank.com/challenges/minimum-distances/problem?isFullScreen=true

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        int n = Integer.parseInt(bufferedReader.readLine().trim());
        List<Integer> a = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());
        int result = Result.minimumDistances(a);
        bufferedReader.close();

        /*
        //List<Integer> a = Arrays.asList(7, 1, 3, 4, 1, 7);
        List<Integer> a = Arrays.asList(1, 2, 3, 4, 10);
        int result = Result.minimumDistances(a);
        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();
        bufferedWriter.close();
         */
        System.out.println(result);
    }
}

class Result {

    /*
     * Complete the 'minimumDistances' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY a as parameter.
     */
    public static int minimumDistances(List<Integer> a) {
        List<DistanceModel> distanceModels = getDistanceModelList(a);
        if (!distanceModels.isEmpty()) {
            int minValue = Integer.MAX_VALUE;
            for (final DistanceModel d : distanceModels) {
                final int first = Math.abs(d.getBegin() - d.getEnd());
                minValue = Math.min(first, minValue);
            }

            return minValue;
        }
        return -1;
    }

    private static List<DistanceModel> getDistanceModelList(List<Integer> a) {
        List<DistanceModel> distanceModels = new ArrayList<>();
        for (int i = 0; i < a.size(); i++) {
            DistanceModel foundDistanceModel = isFoundDistanceModel(a.get(i), distanceModels);
            if (foundDistanceModel != null) {
                foundDistanceModel.setFrequency(foundDistanceModel.getFrequency() + 1);
                foundDistanceModel.setEnd(i);
            } else {
                DistanceModel distanceModel = new DistanceModel();
                distanceModel.setNumber(a.get(i));
                distanceModel.setFrequency(1);
                distanceModel.setBegin(i);
                distanceModel.setEnd(0);
                distanceModels.add(distanceModel);
            }
        }
        distanceModels.sort(Comparator.comparing(DistanceModel::getNumber));
        distanceModels.removeIf(d -> d.getFrequency() <= 1);
        return distanceModels;
    }

    private static DistanceModel isFoundDistanceModel(int num, List<DistanceModel> distanceModels) {
        for (DistanceModel distanceModel : distanceModels) {
            if (num == distanceModel.getNumber()) {
                return distanceModel;
            }
        }

        return null;
    }
}

class DistanceModel {

    private int number;
    private int frequency;
    private int begin;
    private int end;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    public int getBegin() {
        return begin;
    }

    public void setBegin(int begin) {
        this.begin = begin;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }
}
