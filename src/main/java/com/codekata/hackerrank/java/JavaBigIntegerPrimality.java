package com.codekata.hackerrank.java;

import java.math.*;
import java.util.*;

/**
 * The type Java big integer primality.
 */
class JavaBigIntegerPrimality {
     //Problem: https://www.hackerrank.com/challenges/java-primality-test/problem
    private static final Scanner scanner = new Scanner(System.in);

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        String a = scanner.nextLine();
        BigInteger n = new BigInteger(a);
        scanner.close();
        if (n.equals(2)){
            System.out.print("prime");
        }else{

            if(n.isProbablePrime(100))
                System.out.println("prime");
            else
                System.out.println("not prime");
            
            
            /* 
            //Second Way without using isProbablePrime(). it's slower.
            int sum = 0;
            for (BigInteger bi = BigInteger.valueOf(1); bi.compareTo(n) < 0; bi = bi.add(BigInteger.ONE)) {
                if(n.mod(n.subtract(bi))==BigInteger.ZERO)
                    sum++;
            }
            if(sum==1)
                System.out.println("prime");
            else
                System.out.println("not prime");
             */
        }
    }
}