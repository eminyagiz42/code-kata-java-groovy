package curiousity;

public class NumberInSentence {

    public static void main(String[] args) {

        String str = "this is very long sentence 1994 it doesn't need a meaining";
        str = str.replaceAll("\\D+", ""); // regex for only decimal numbers

        final int age = 2023 - Integer.parseInt(str);
        System.out.println("this is my age " + age);
    }
}
