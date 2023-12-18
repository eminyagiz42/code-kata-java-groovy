package com.codekata.practice.readFile;


import java.io.BufferedReader;
import java.io.FileReader;


public class BannerPrinter {

    public static final String FILE_PATH = "src/main/java/com/codekata/practice/readFile/my-banner.txt";

    public static void main(String[] args) {
        printBanner();
    }

    public static synchronized void printBanner() {
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))){
            StringBuilder builder = new StringBuilder();
            String st;
            while ((st = br.readLine()) != null) {
                builder.append(st).append("\n");
            }
            System.out.println(builder);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}