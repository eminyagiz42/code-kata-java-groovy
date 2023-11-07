package com.codekata.hackerrank;

import java.util.*;

class JavaSubarray {

    private static final Scanner scanner = new Scanner(System.in);
    private static int counter = 0;

    //Problem : https://www.hackerrank.com/challenges/java-negative-subarray/problem

    public static void main(String[] args) {
        try{
            int numberOfInputs =  scanner.nextInt();
            int[] arr =  new int[numberOfInputs];
            for (int i = 0; i <numberOfInputs ; i++) {
                arr[i] = scanner.nextInt();
            }
            
//Test case
/* int[] arr = new int[]{255, -77, 601, 89, -993, -307, 300, 452, -312, 400, -993, 831,
                    790, 236, 981, 274, 167, 676, -134, -906, 139, -537, -159, 483,
                    398, 253, 583, 348, 582, 481, 398, -504, 459, 39, 650, 424,
                    511, 581, 303, 142, -300, 796, 183, -609, 432, 33, -846, -101,
                    421, 602, -789, 214, 692, -971, 212, 752, -564, -747, -396, 217,
                    448, 364, -139, 304, -309, 337, 989, 751, 698, 381, 892, -774,
                    34, 557, 231, 612, -377, -677, 497, -781, -944, 608, 21, 967,
                    787, -334, 835, 136, 335, -4, -468, -301, -296, 65, -664,
                    -303, 317, 893, 624, 115};*/ 

            printSubArrays(arr,0,0);
            System.out.println(counter);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    static void printSubArrays(int[] arr, int start, int end) {
        int total = 0;
        if (end == arr.length)
            return;
        else if (start > end)
            printSubArrays(arr, 0, end + 1);
        else {
            for (int i = start; i < end; i++){
                total = total + arr[i];
            }
            total = total +arr[end];
            if(total<0)
                counter++;
            printSubArrays(arr, start + 1, end);
        }
        return;
    }
}