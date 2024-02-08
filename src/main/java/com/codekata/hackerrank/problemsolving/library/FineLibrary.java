package com.codekata.hackerrank.problemsolving.library;


import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;


public class FineLibrary {

    //https://www.hackerrank.com/challenges/library-fine/problem?isFullScreen=true

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
        int d1 = Integer.parseInt(firstMultipleInput[0]);
        int m1 = Integer.parseInt(firstMultipleInput[1]);
        int y1 = Integer.parseInt(firstMultipleInput[2]);
        String[] secondMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
        int d2 = Integer.parseInt(secondMultipleInput[0]);
        int m2 = Integer.parseInt(secondMultipleInput[1]);
        int y2 = Integer.parseInt(secondMultipleInput[2]);
        int result = Result.libraryFine(d1, m1, y1, d2, m2, y2);
        System.out.println(result);
        //bufferedWriter.write(String.valueOf(result));
        //bufferedWriter.newLine();
        //bufferedWriter.close();
        bufferedReader.close();
    }
}

class Result {

    /*
     * Complete the 'libraryFine' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER d1
     *  2. INTEGER m1
     *  3. INTEGER y1
     *  4. INTEGER d2
     *  5. INTEGER m2
     *  6. INTEGER y2
     */
    public static int libraryFine(int d1, int m1, int y1, int d2, int m2, int y2) {
        try {

            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
            Date returnDate = sdf.parse(d1 + "/" + m1 + "/" + y1);
            Date dueDate = sdf.parse(d2 + "/" + m2 + "/" + y2);

            if (returnDate.before(dueDate)) {
                return 0;
            } else {
                if (returnDate.equals(dueDate)) {
                    return 0;
                } else if (returnDate.getYear() == dueDate.getYear() && returnDate.getMonth() == dueDate.getMonth()) {
                    int daysDifference = Math.abs(dueDate.getDate() - returnDate.getDate());
                    return 15 * daysDifference;
                } else if (returnDate.getYear() == dueDate.getYear() && returnDate.getMonth() != dueDate.getMonth()) {
                    int monthDifference = Math.abs(dueDate.getMonth() - returnDate.getMonth());
                    return monthDifference * 500; //Not included days in fine calculation
                } else {
                    return 10_000; // Maximum fine
                }
            }

        } catch (ParseException exception) {
            System.out.println(" ParseException is occurred!");
        }

        return -1;
    }

}

/*
14 7 2018
5 7 2018
expected output: 135

9 6 2015
6 6 2015
expected output: 45

31 8 2004
20 1 2004
expected output: 3500

2 7 1014
1 1 1015
expected output: 0
because return date is before due date

2 7 2015
1 2 2014
10000

5 5 2014
23 2 2014
1500

31 8 2004
20 1 2004
3500
 */