package com.codekata.hackerrank.problemsolving.cat;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class CatAndMouse {

    //https://www.hackerrank.com/challenges/cats-and-a-mouse/problem?isFullScreen=true

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        /*
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        for (int qItr = 0; qItr < q; qItr++) {
            String[] xyz = scanner.nextLine().split(" ");
            int x = Integer.parseInt(xyz[0]);
            int y = Integer.parseInt(xyz[1]);
            int z = Integer.parseInt(xyz[2]);
            String result = catAndMouse(x, y, z);
            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }
        bufferedWriter.close();
        scanner.close();
         */

        //int x = 2, y = 5, z = 4; // Cat B
        int x = 1, y = 2, z = 3; // Cat B
        //int x = 1, y = 3, z = 2; // Mouse C
        String result = catAndMouse(x, y, z);
        System.out.println(result);
    }

    static String catAndMouse(int x, int y, int z) {
        final int catA = Math.abs(x - z);
        final int catB = Math.abs(y - z);

        if (catA == catB) {
            return "Mouse C";
        } else if (catA < catB) {
            return "Cat A";
        } else {
            return "Cat B";
        }
    }
}
