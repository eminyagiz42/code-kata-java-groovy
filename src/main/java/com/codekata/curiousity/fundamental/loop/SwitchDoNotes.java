package com.codekata.curiousity.fundamental.loop;

public class SwitchDoNotes {

    public static void main(String[] args) {
        int day = 4;
        switch (day) {
            case 1:
                System.out.println("Monday");
                break;
            case 2:
                System.out.println("Tuesday");
                break;
            case 3:
                System.out.println("Wednesday");
                break;
            case 4:
                System.out.println("Thursday");
                break;
            case 5:
                System.out.println("Friday");
                break;
            case 6:
                System.out.println("Saturday");
                break;
            case 7:
                System.out.println("Sunday");
                break;
            default:
                System.out.println("Outside of  days");
            }


        int i = 0;
        do {
            System.out.println(i);
            i++;
        }
        while (i < 5);


        int j = 0;
        while (j < 5) {
            System.out.println(j);
            j++;
        }

        for (int k = 0; k < 5; k++) {
            System.out.println(k);
        }

        System.out.println();

        for (int m = 0; m < 10; m++) {
            if (m == 5) {
                break;
            }
            System.out.println("m = " + m);
        }

        System.out.println();

        for (int n = 0; n < 10; n++) {
            if (n == 4) {
                continue;
            }
            System.out.println("n = " + n);
        }

        }
    }
