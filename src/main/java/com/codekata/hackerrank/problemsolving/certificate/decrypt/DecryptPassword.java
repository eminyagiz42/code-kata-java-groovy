package com.codekata.hackerrank.problemsolving.certificate.decrypt;


import java.io.IOException;


public class DecryptPassword {

    public static void main(String[] args) throws IOException {
        /*
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        String s = bufferedReader.readLine();
        String result = Result.decryptPassword(s);
        bufferedWriter.write(result);
        bufferedWriter.newLine();
        bufferedReader.close();
        bufferedWriter.close();
         */

        String s = "pTo*Ta*O"; // expected output: poTaTO
        //String s = "51Pa*0Lp*0e"; // expected output: aP1pL5e
        String result = Result.decryptPassword(s);
        System.out.println(result);
    }
}

class Result {

    /*
     * Complete the 'decryptPassword' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */
    public static String decryptPassword(String s) {
        final char[] charArray = s.toCharArray();
        int count = 0;
        int index = 0;
        for (int i = charArray.length - 1; i >= 0; i--) {
            if (charArray[i] == '0') {
                if (Character.isDigit(charArray[index])) {
                    charArray[i] = charArray[index];
                    index++;
                    count++;
                }
            } else if (charArray[i] == '*') {
                swapTwoChars(charArray, i - 1, i - 2);
            }
        }

        return new String(charArray).substring(count).replace("*", "");
    }

    public static void swapTwoChars(char[] inputArray, int index1, int index2) {
        if (index1 >= 0 && index1 < inputArray.length && index2 >= 0 && index2 < inputArray.length) {
            char temp = inputArray[index1];
            inputArray[index1] = inputArray[index2];
            inputArray[index2] = temp;
        }
    }

}

