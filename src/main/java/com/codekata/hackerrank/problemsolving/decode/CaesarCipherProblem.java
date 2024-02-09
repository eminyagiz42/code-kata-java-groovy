package com.codekata.hackerrank.problemsolving.decode;

import java.io.*;
import java.util.Arrays;
import java.util.List;


public class CaesarCipherProblem {

    //https://www.hackerrank.com/challenges/caesar-cipher-1/problem

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        int n = Integer.parseInt(bufferedReader.readLine().trim());
        String s = bufferedReader.readLine();
        int k = Integer.parseInt(bufferedReader.readLine().trim());
        String result = Result.caesarCipher(s, k);
        System.out.println(result);
        //bufferedWriter.write(result);
        //bufferedWriter.newLine();
        //bufferedWriter.close();
        bufferedReader.close();
    }
}

class Result {

    /*
     * Complete the 'caesarCipher' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. STRING s
     *  2. INTEGER k
     */
    private static final List<String> alphabet = Arrays.asList("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z");

    public static String caesarCipher(String s, int k) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            String characterOfText = String.valueOf(s.charAt(i));
            if (alphabet.contains(characterOfText)) {
                final int shiftedIndex = (alphabet.indexOf(characterOfText) + k) % 26;
                builder.append(alphabet.get(shiftedIndex));
            } else {
                if (alphabet.contains(characterOfText.toLowerCase())) {
                    final int shiftedIndex = (alphabet.indexOf(characterOfText.toLowerCase()) + k) % 26;
                    characterOfText = alphabet.get(shiftedIndex).toUpperCase();
                }
                builder.append(characterOfText);
            }
        }
        return builder.toString();
    }
}

/*
11
middle-Outz
2
expected output:
okffng-Qwvb
 */