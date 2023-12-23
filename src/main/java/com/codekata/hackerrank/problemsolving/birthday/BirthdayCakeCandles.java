package com.codekata.hackerrank.problemsolving.birthday;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class BirthdayCakeCandles {

    //https://www.hackerrank.com/challenges/birthday-cake-candles/problem?isFullScreen=true

    public static void main(String[] args) throws IOException {
        /*
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        int candlesCount = Integer.parseInt(bufferedReader.readLine().trim());
        List<Integer> candles = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());
        int result = Result.birthdayCakeCandles(candles);
        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();
        bufferedReader.close();
        bufferedWriter.close();
                 */

        List<Integer> candles = Arrays.asList(3, 2, 1, 3); // expected output: 2
        int result = Result.birthdayCakeCandles(candles);
        System.out.println(result);
    }
}

class Result {

    /*
     * Complete the 'birthdayCakeCandles' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY candles as parameter.
     */
    public static int birthdayCakeCandles(List<Integer> candles) {
        int highest = 0;
        int count = 0;
        for (Integer integer : candles) {
            highest = Math.max(integer, highest);
        }
        for (Integer candle : candles) {
            if (candle == highest) {
                count++;
            }
        }
        return count;
    }
}