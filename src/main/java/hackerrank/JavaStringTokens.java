package hackerrank;

import java.util.*;

class JavaStringTokens {
   //Problem:https://www.hackerrank.com/challenges/java-string-tokens/problem

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        String array[] = replaceSymbolToSpace(s).split("\\s+");

        if (array.length == 0) {
        } else {
            if (array[0].isEmpty() )
            array = removeArrayFirstElement(array);
        }

        System.out.println(array.length);

        for (String arr:array) {
            System.out.println(arr);
        }

        scan.close();
    }

    private static String[] removeArrayFirstElement(String[] array) {
        String[] newArray = new String[array.length-1];
        System.arraycopy(array,1,newArray,0,array.length-1);
        return newArray;
    }

    private static String replaceSymbolToSpace(String s) {
        return s.replace("?"," ").replace("'"," ").replace(","," ").replace("!"," ").replace("_"," ").replace("@"," ").replace("."," ");
    }

}
