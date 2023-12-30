package com.codekata.hackerrank.problemsolving.bill;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class BillDivision {

    //https://www.hackerrank.com/challenges/bon-appetit/problem?isFullScreen=true

    public static void main(String[] args) throws IOException {
        /*
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
        int n = Integer.parseInt(firstMultipleInput[0]);
        int k = Integer.parseInt(firstMultipleInput[1]);
        List<Integer> bill = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());
        int b = Integer.parseInt(bufferedReader.readLine().trim());
        Result.bonAppetit(bill, k, b);
        bufferedReader.close();
        */

        int n = 4, k = 1;
        List<Integer> bill = Arrays.asList(3, 10, 2, 9);
        //int b = 12; // 5
        int b = 7; //Bon Appetit

        Result.bonAppetit(bill, k, b);
    }
}


class Result {

    /*
     * Complete the 'bonAppetit' function below.
     *
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY bill
     *  2. INTEGER k
     *  3. INTEGER b
     */
    public static void bonAppetit(List<Integer> bill, int k, int b) {
        int totalBill = 0;
        for (int i = 0; i < bill.size(); i++) {
            if (i != k) {
                totalBill += bill.get(i);
            }
        }
        final int costPerPerson = totalBill / 2;
        //System.out.println(costPerPerson);
        if (costPerPerson == b) {
            System.out.println("Bon Appetit");
        } else {
            System.out.println(Math.abs(costPerPerson - b));
        }
    }
}