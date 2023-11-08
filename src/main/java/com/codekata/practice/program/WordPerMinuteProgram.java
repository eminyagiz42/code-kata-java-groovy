package com.codekata.practice.program;

import java.time.LocalTime;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

/**
 * The type Word per minute program.
 */
public class WordPerMinuteProgram {

    /**
     * The Keywords.
     */
    public static String[] keywords = {"Lorem", "ipsum", "dolor", "sit", "amet", "consectetur", "adipiscing", "elit", "sed", "do"};

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     * @throws InterruptedException the interrupted exception
     */
    public static void main(String[] args) throws InterruptedException {

        System.out.println("3");
        TimeUnit.SECONDS.sleep(1);
        System.out.println("2");
        TimeUnit.SECONDS.sleep(1);
        System.out.println("1");
        TimeUnit.SECONDS.sleep(1);

        Random random = new Random();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            final String word = keywords[random.nextInt(9)] + " ";
            builder.append(word);
        }
        System.out.println(builder);

        Scanner scanner = new Scanner(System.in);
        double start = LocalTime.now().toNanoOfDay();
        final String next = scanner.nextLine();

        double counter = 0.0;
        for (int i = 0; i < next.length(); i++) {
            if (builder.charAt(i) == next.charAt(i)) {
                counter++;
            }
        }

        double finish = LocalTime.now().toNanoOfDay();
        double timeElapsed = finish - start;
        double seconds = timeElapsed / 1000000000.0;
        if (counter > 0) {
            double wordPerMinute = ((counter / 5) / seconds) * 60;
            System.out.println("your word pre minute is " + Math.round(wordPerMinute) + "!");
        } else {
            System.out.println("Error: No characters are the same as shown sentence!");
        }

    }
}
