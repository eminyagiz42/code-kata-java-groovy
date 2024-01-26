package com.codekata.hackerrank.problemsolving.jumping;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class JumpingCloudsRevisited {

    //https://www.hackerrank.com/challenges/jumping-on-the-clouds-revisited/problem?isFullScreen=true

    //private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        /*
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        String[] nk = scanner.nextLine().split(" ");
        int n = Integer.parseInt(nk[0]);
        int k = Integer.parseInt(nk[1]);
        int[] c = new int[n];
        String[] cItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        for (int i = 0; i < n; i++) {
            int cItem = Integer.parseInt(cItems[i]);
            c[i] = cItem;
        }
        int result = jumpingOnClouds(c, k);
        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();
        bufferedWriter.close();
        scanner.close();
         */
        // int k = 2;
        // int[] c = {0, 0, 1, 0, 0, 1, 1, 0}; // 92
        int k = 3;
        int[] c = {1, 1, 1, 0, 1, 1, 0, 0, 0, 0}; // 80
        int result = jumpingOnClouds(c, k);
        System.out.println(result);

    }

    static int jumpingOnClouds(int[] c, int k) {
        int energy = 100;
        final int length = c.length;

        energy = spendEnergy(c[0], energy);// cloud start address
        for (int i = getCloudAddress(0, k, length); i != 0; i = getCloudAddress(i, k, length)) {
            energy = spendEnergy(c[i], energy);
        }

        return energy;
    }

    private static int spendEnergy(int number, int energy) {
        energy--;

        if (number == 1) {
            energy -= 2;
        }
        return energy;
    }


    private static int getCloudAddress(int cloud, int k, int n) {
        return (cloud + k) % n; //It's the formula provided in problem description
    }

    static int jumpingOnClouds2(int[] c, int k) { // Since we always need c[0] run before loop, do-while is better approach
        int energy = 100;
        int address = 0;
        do {
            energy--;

            address = getCloudAddress(address, k, c.length);

            if (c[address] == 1) {
                energy -= 2;
            }
        }
        while (address != 0);

        return energy;
    }
}
