package com.codekata.hackerrank.certificate.problemSolving.rename;


import java.io.IOException;
import java.util.Arrays;

public class RenameFile {

    public static void main(String[] args) throws IOException {
        /*
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        String newName = bufferedReader.readLine();
        String oldName = bufferedReader.readLine();
        int result = Result.renameFile(newName, oldName);
        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();
        bufferedReader.close();
        bufferedWriter.close();
         */

        String newName = "aba";
        String oldName = "ababa";
        int result = Result.renameFile(newName, oldName);
        System.out.println(result);
    }
}


class Result {

    private final static int M = 1000000007;

    /*
     * Complete the 'renameFile' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. STRING newName
     *  2. STRING oldName
     */
    public static int renameFile(String newName, String oldName) {
        int n = oldName.length();
        int[] arrayDpFirst = new int[n + 1];
        Arrays.fill(arrayDpFirst, 1);
        for (int i = 1; i <= newName.length(); i++) {
            int[] arrayDpSecond = new int[n + 1];
            for (int j = i; j <= n; j++) {
                arrayDpSecond[j] = arrayDpSecond[j - 1];
                if (newName.charAt(i - 1) == oldName.charAt(j - 1))
                    arrayDpSecond[j] = ((arrayDpSecond[j] % M) + (arrayDpFirst[j - 1] % M)) % M;
            }
            arrayDpFirst = arrayDpSecond;
        }
        return arrayDpFirst[n] % M;
    }

    public static int renameFile2(String newName, String oldName) { // Not completed

        final int size = oldName.length() - newName.length();

        StringBuilder builder = new StringBuilder();
        int index = 0;
        for (int i = 0; i < oldName.length(); i++) {
            for (int j = 0; j < newName.length(); j++) {
                if (j == i || j == i + 1) {

                } else {
                    builder.append(oldName.charAt(j));
                }
            }
            builder.append(" ");
        }
        System.out.println(builder);

        /*
        for (int i = 0; i <= oldName.length() - newName.length() ; i++) {
            String subsequence = oldName.substring(i, i + newName.length() );
            System.out.println(subsequence);
        }
        */

        return -1;
    }


}