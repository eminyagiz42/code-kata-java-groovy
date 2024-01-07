package com.codekata.hackerrank.problemsolving.designerpdf;


import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class DesignerPDFViewer {

    //https://www.hackerrank.com/challenges/designer-pdf-viewer/problem?isFullScreen=true

    public static void main(String[] args) throws IOException {
        /*
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        List<Integer> h = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());
        String word = bufferedReader.readLine();
        int result = Result.designerPdfViewer(h, word);
        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();
        bufferedReader.close();
        bufferedWriter.close();
        */
        String word = "abc"; // expected output: 9
        List<Integer> h = Arrays.asList(1, 3, 1, 3, 1, 4, 1, 3, 2, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5);
        int result = Result.designerPdfViewer(h, word);
        System.out.println(result);
    }
}

class Result {

    /*
     * Complete the 'designerPdfViewer' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY h
     *  2. STRING word
     */

    public static final int DEFAULT_WIDTH = 1;

    public static int designerPdfViewer(List<Integer> h, String word) {

        Map<Character, Integer> alphabetAndIndex = getAllAlphabetAndIndex();

        int highest = 0;
        for (char letter : word.toCharArray()) {
            highest = Math.max(h.get(alphabetAndIndex.get(letter)), highest);
        }

        return highest * word.length() * DEFAULT_WIDTH;
    }

    private static Map<Character, Integer> getAllAlphabetAndIndex() {
        Map<Character, Integer> map = new HashMap<>();
        int index = 0;
        for (int i = 97; i <= 122; i++) {
            map.put((char) i, index++);
        }
        return map;
    }

}
