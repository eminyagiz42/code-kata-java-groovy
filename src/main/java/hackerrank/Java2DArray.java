package hackerrank;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class Java2DArray {

//Problem: https://www.hackerrank.com/challenges/java-2d-array/problem

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int[][] arr = new int[6][6];

        for (int i = 0; i < 6; i++) {
            String[] arrRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 6; j++) {
                int arrItem = Integer.parseInt(arrRowItems[j]);
                arr[i][j] = arrItem;
            }
        }

        scanner.close();

        ArrayList<Integer> arrayList = new ArrayList();

        // find all possible the hourglasses
        // calculate the total in each hourglass
        //  and save it on arrayList

        for (int i = 0; i <arr.length-2 ; i++) {
            for (int j = 0; j <arr.length-2 ; j++) {
                arrayList.add(arr[i][j] + arr[i][j+1] + arr[i][j+2]
                        + arr[i+1][j+1] +
                        arr[i+2][j] + arr[i+2][j+1] + arr[i+2][j+2]);
            }
        }

        //biggest number in the array list
        System.out.println(Collections.max(arrayList));
    }
}
