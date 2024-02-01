package com.codekata.hackerrank.certificate.decyprt;

import java.io.*;
import java.util.*;
import java.util.regex.*;

import static java.util.stream.Collectors.joining;


public class DecryptMessage {

    public static void main(String[] args) throws IOException {
        /*
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        String encryptedMessage = bufferedReader.readLine();
        String result = Result.decryptMessage(encryptedMessage);
        bufferedWriter.write(result);
        bufferedWriter.newLine();
        bufferedReader.close();
        bufferedWriter.close();
        */

        //String encryptedMessage = "world hel2o";
        //String encryptedMessage = "seaside the to sent be to ne2ds army ten of team a";
        //String encryptedMessage = "mis2is2ip2i ba3";
        String encryptedMessage = "   world   hel2o   ";
        String result = Result.decryptMessage(encryptedMessage);
        System.out.println(result);
    }
}

class Result {

    /*
     * Complete the 'decryptMessage' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING encryptedMessage as parameter.
     */

    /*
     * Complete the 'decryptMessage' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING encryptedMessage as parameter.
     */
    public static String decryptMessage(String encryptedMessage) {  // Compiled successfully. 11/15 test cases passed
        final String[] messages = encryptedMessage.split(" "); // I'd like to keep the space delimiter ((?= ))
        StringBuilder builder = new StringBuilder();
        for (int i = messages.length - 1; i >= 0; i--) {
            if (messages[i].matches(".*\\d.*")) {
                builder.append(handleWordWithNumbers(messages[i]));
            } else {
                builder.append(messages[i] + " ");
            }
        }
        return builder.toString();
    }

    private static String handleWordWithNumbers(String message) {
        StringBuilder howMany = new StringBuilder();
        String[] charArray = message.split("");
        for (int j = 0; j < charArray.length; j++) {
            if (Character.isDigit(charArray[j].charAt(0))  && charArray[j-1].charAt(0) != ' ') {
                for (int k = 0; k < Integer.parseInt(charArray[j]) - 1; k++) {
                    howMany.append(charArray[j - 1]);
                }
            } else {
                howMany.append(charArray[j]);
            }
        }
        howMany.append(" ");
        return howMany.toString();
    }

    public static String decryptMessage1(String encryptedMessage) {

        String[] words = encryptedMessage.split(" ");
        List<String> reversedWords = new ArrayList<>();
        for (String word : words) {
            StringBuilder reversedWord = new StringBuilder(word).reverse();
            reversedWords.add(reversedWord.toString());
        }
        Collections.reverse(reversedWords);
        String reversedSentence = String.join(" ", reversedWords);


        Pattern pattern = Pattern.compile("([a-zA-Z])(\\d+)");
        Matcher matcher = pattern.matcher(reversedSentence);
        StringBuilder decryptedSentence = new StringBuilder();
        int prevIndex = 0;
        while (matcher.find()) {
            decryptedSentence.append(reversedSentence, prevIndex, matcher.start());
            char letter = matcher.group(1).charAt(0);
            int frequency = Integer.parseInt(matcher.group(2));
            decryptedSentence.append(String.valueOf(letter).repeat(Math.max(0, frequency)));
            prevIndex = matcher.end();
        }
        decryptedSentence.append(reversedSentence.substring(prevIndex));
        return decryptedSentence.toString();
    }


    public static String decryptMessage2(String encryptedMessage) {
        StringBuilder builder = new StringBuilder();
        char previousChar = ' ';
        int count = 0;
        List<String> words = new ArrayList<>();

        for (char c : encryptedMessage.toCharArray()) {
            if (Character.isDigit(c) && previousChar != ' ') {
                count = count * 10 + Character.getNumericValue(c);
            } else {
                if (count > 0) {
                    count--;
                    builder.append(String.join("", Collections.nCopies(count, String.valueOf(previousChar))));
                    count = 0;
                }
                builder.append(c);
                previousChar = c;
                if (c == ' ') {
                    words.add(builder.toString());
                    builder.setLength(0);
                }
            }
        }

        if (count > 0) {
            count--;
            builder.append(String.join("", Collections.nCopies(count, String.valueOf(previousChar))));
        }
        words.add(builder.toString());

        Collections.reverse(words);

        return String.join(" ", words);
    }

}


