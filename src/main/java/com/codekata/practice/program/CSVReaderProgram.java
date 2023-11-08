package com.codekata.practice.program;

import java.io.*;

/**
 * The type Csv reader program.
 */
public class CSVReaderProgram {

    /**
     * The constant csv.
     */
    public static final File csv =  new File("src/main/resources/insurance.csv");
    /**
     * The constant line.
     */
    public static String line;

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
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
