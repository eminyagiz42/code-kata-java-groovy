package practice;

import util.Constant;
import util.Impl.CommandImpl;
import util.Utilities;

public class FindDuplicates {

    public static void main(String[] args) {

        String sentence1 = "How many duplicates are there ?";
        Utilities.callCommand(new CommandImpl(), findDuplicates(Constant.VERY_LONG_SENTENCE), System.currentTimeMillis());

        long start = System.currentTimeMillis();
        System.out.println(findDuplicates2(Constant.VERY_LONG_SENTENCE));
        long finish = System.currentTimeMillis();
        long timeElapsed = finish - start;
        System.out.println("timeElapsed = " + timeElapsed);
    }

    public static String findDuplicates(String str) { //78ms
        StringBuilder duplicates = new StringBuilder();
        StringBuilder characters = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            final String current = Character.toString(str.charAt(i));
            if (characters.toString().contains(current)
                    && !duplicates.toString().contains(current)) {
                duplicates.append(current);
            }
            characters.append(current);
        }
        return duplicates.toString();
    }

    public static String findDuplicates2(String str) { //209ms
        String duplicates = "";
        String characters = "";
        for (int i = 0; i < str.length(); i++) {
            final String current = Character.toString(str.charAt(i));
            if (characters.contains(current)){
                if(!duplicates.contains(current)) {
                    duplicates += current;
                }
            }
            characters += current;
        }
        return duplicates;
    }

    public static String findDuplicatesSlow(String str) { //2208ms
        StringBuilder stringBuilder = new StringBuilder();
        final char[] charArray = str.toCharArray();
        for (char c : charArray) {
            int count = 0;
            for (char value : charArray) {
                if (c != ' ' && c == value) {
                    count++;
                    if (count >= 2 && !stringBuilder.toString().contains(Character.toString(c))) {
                        stringBuilder.append(c);
                    }
                }
            }
        }
        return stringBuilder.toString();
    }

}
