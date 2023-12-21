package com.codekata.hackerrank.java;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class EncryptionProblem {

    //https://www.hackerrank.com/challenges/sha-256/problem

    public static final String SHA_256 = "SHA-256";

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        final String message = s.nextLine();
        s.close();
        System.out.println(encrypt(message, SHA_256));
    }

    private static String encrypt(String message, String algorithm) {
        try {
            MessageDigest md = MessageDigest.getInstance(algorithm);

            byte[] hash = md.digest(message.getBytes());

            StringBuilder builder = new StringBuilder(2 * hash.length);

            for (byte b : hash) {
                builder.append(String.format("%02x", b & 0xff));
            }

            return builder.toString();

        } catch (NoSuchAlgorithmException ex) {
             ex.printStackTrace();
        }
        return "";
    }
}
