package com.codekata.practice.program;

import java.io.*;

public class CSVReaderProgram {

    public static final File csv =  new File("src/main/resources/insurance.csv");
    public static String line;

    public static void main(String[] args) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(csv));
            final String title = bufferedReader.readLine().split(",")[5];
            while ((line = bufferedReader.readLine()) != null) {
                final String[] split = line.split(",");
                final double value = Double.parseDouble(split[5]);
                if (value > 0) {
                    System.out.println(title + " : " + value);
                }
            }
        } catch (FileNotFoundException ex){
            System.out.println("No File Found");
            ex.printStackTrace();
        } catch (IOException ex){
            System.out.println("IOException Exception");
            ex.printStackTrace();
        }
    }
}
