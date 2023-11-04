package curiousity.exception;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class ExceptionsNotes {

    public static void main(String[] args) {
        try{
            int i = 5 / 0;
        }catch(ArithmeticException ex) {
            System.out.printf("ArithmeticException occured, the reason is %s", ex.getMessage());
        }

        System.out.println();

        try{
            int[] arr = new int[2];
            arr[0] = 9;
            arr[1] = 8;
            System.out.println(arr[2]);
        }catch(IndexOutOfBoundsException ex) {
            System.out.printf("IndexOutOfBoundsException occured, there is not index %s in the array ", ex.getMessage());
        }

        System.out.println();
        try{
            String a = "abx";
            int b = Integer.valueOf(a);
        }catch(NumberFormatException ex) {
            System.out.printf("NumberFormatException occured, the reason is %s ", ex.getMessage());
        }

        try{
            String a = null; //null value
            System.out.println(a.charAt(0));
        }catch(NullPointerException ex) {
            System.out.printf("NullPointerException occured, the reason is %s ", ex.getMessage());
        }

        try {
            String a = "This is a sentence "; // length is 18
            char c = a.charAt(24); // accessing 25th element
            System.out.println(c);
        }
        catch(StringIndexOutOfBoundsException e) {
            System.out.println("StringIndexOutOfBoundsException");
        }

        try {
            File file = new File("E://file.txt");// this file does not exist
            FileReader fr = new FileReader(file);
        } catch (FileNotFoundException e) {
            System.out.println("File does not exist");
        }

        try {
            Set exampleleSet = new HashSet();
            Hashtable exampleTable = new Hashtable();
            exampleleSet.iterator().next();
            exampleTable.elements().nextElement();
        } catch (NoSuchElementException e) {
            System.out.println("NoSuchElementException is occured");
        }


        int age = 29; // if less than 18, it will throw exception

        if(age >= 18){
            System.out.println("You're eligible for Voting");
        }  else{
            throw new IllegalArgumentException("You're not eligible for Voting");
        }

        try {
            double ballance = 999.0;
            if (ballance < 1000) {
                throw new MyCustomException("Balance is less than 1000");
            }
        } catch (MyCustomException e) {
            e.printStackTrace();
        }

        /** Output :
         * curiousity.exception.MyCustomException: Balance is less than 1000
         * at curiousity.exception.ExceptionsNotes.main(ExceptionsNotes.java:86)
         */


        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println(scanner.nextInt());

        } catch(ArithmeticException e) {
                //do something
        } catch(Exception e) {
            //do something
        } finally{
            // always run
            scanner.close();
        }
    }
}
