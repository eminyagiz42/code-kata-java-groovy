package com.codekata.hackerrank.problemsolving.viral;

import java.io.IOException;

public class ViralAdvert {

    //https://www.hackerrank.com/challenges/strange-advertising/problem?isFullScreen=true

    public static void main(String[] args) throws IOException {
        /*
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        int n = Integer.parseInt(bufferedReader.readLine().trim());
        int result = Result.viralAdvertising(n);
        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();
        bufferedReader.close();
        bufferedWriter.close();
        */
        int result = Result.viralAdvertising(5);
        System.out.println(result);
    }
}


class Result {

    /*
     * Complete the 'viralAdvertising' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER n as parameter.
     */
    public static int viralAdvertising(int n) {
        int peopleLiked = 5;
        int cumulative = 0;
        for (int i = 1; i <= n; i++) {
            final double sharedWithFriends = Math.floor((peopleLiked / 2.0));
            peopleLiked = (int) (sharedWithFriends * 3);
            cumulative += sharedWithFriends;
        }
        return cumulative;
    }
}

/*
Day Shared Liked Cumulative
1      5     2       2
2      6     3       5
3      9     4       9
4     12     6      15
5     18     9      24
 */