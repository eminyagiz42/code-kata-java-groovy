package com.codekata.curiousity.fundamental;

public class DataTypeNotes {
    public static void main(String[] args) {
        //Primitive Types
        byte a = 127; // Byte.MAX_VALUE
        short b = 32767; //Short.MAX_VALUE
        int d = 2147483647; // Integer.MAX_VALUE;
        long c = 9223372036854775807L; //  9223372036854775808L invalid
        float flo =  3.4028235e+38F ; // Float.MAX_VALUE + 1F = 3.4028235E38 (addition but no increase)
        double db = 3.03; // Double.MAX_VALUE
        boolean bool = false;
        char ch =  'e';

        /* Wrapper Types
        String
        Byte
        Short
        Integer
        Long
        Float
        Double
        Boolean
        Character
        */

        // Type Conversion
        // double -> float -> long -> int -> short -> byte (Narrowing)

        double doubleVar = 100.04;
        long longVar = (long)doubleVar;
        int intVar = (int)longVar;
        System.out.println("Double value " + doubleVar);
        System.out.println("Long value " + longVar);
        System.out.println("Int value " + intVar);

        //However Some times conversion maybe not required, it does automatically

        // byte -> short -> int -> long -> float -> double (Widening )

        int autoInt = 100;
        long autoLong = autoInt; // Automatic type conversion
        float autoFloat = autoLong;
        double autoDouble = autoInt;
        System.out.println("Int value " + autoInt);
        System.out.println("Long value " + autoLong);
        System.out.println("Float value " + autoFloat);
        System.out.println("Double value " + autoDouble); // IF we convert int to double, no need to cast.

    }
}
