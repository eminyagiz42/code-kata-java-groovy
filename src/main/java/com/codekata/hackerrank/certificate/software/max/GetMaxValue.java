package com.codekata.hackerrank.certificate.software.max;


import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class GetMaxValue {

    public static void main(String[] args) throws IOException {
        /*
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        int arrCount = Integer.parseInt(bufferedReader.readLine().trim());
        List<Integer> arr = IntStream.range(0, arrCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(toList());
        int result = Result.getMaxValue(arr);
        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();
        bufferedReader.close();
        bufferedWriter.close();
        */

        List<Integer> arr = Arrays.asList(3, 1, 3, 4); // expected output: 2
        //List<Integer> arr = Arrays.asList(1, 3, 3, 2); // expected output: 3
        //List<Integer> arr = Arrays.asList(1, 3, 2, 2); // expected output: 3
        int result = Result.getMaxValue(arr);
        System.out.println(result);
    }
}

class Result {

    /*
     * Complete the 'getMaxValue' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */
    public static int getMaxValue(List<Integer> arr) {
        Collections.sort(arr);
        int index = 1;
        for (int i = 0; i < arr.size(); i++) {
            if (index != arr.get(i)) {
                arr.set(i, arr.get(i) - 1);
            }
            index++;
        }

        int highest = 0;
        for (int element : arr) {
            highest = Math.max(highest, element);
        }
        return highest;
    }

}