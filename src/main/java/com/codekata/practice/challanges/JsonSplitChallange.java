package com.codekata.practice.challanges;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class JsonSplitChallange {

    public static void main(String[] args) throws IOException {
       File file = new File("src/main/resources/jsonFile.json");

        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        String s = "";
        String line;
        while (( line = bufferedReader.readLine()) != null) {
          //  if (!line.contains("N/A")) { //let's make it harder
                s = s.concat(line);
            //}
        }

        System.out.println(s);
       // output --> {  "name": {    "first": "Daniel",    "middle": "N/A",    "last": "Smith"  },  "age": 45}

        final String[] split = s.split("(?<=\\{)");// split by { and keep the delimiter {
        for (String s1 : split) {
            final String[] split1 = s1.split("(?<=})");
            for (String s2 : split1) {
                final String[] split2 = s2.split("(?<=,)");
                for (String s3 : split2) {
                    if (!s3.contains("N/A")) {
                        System.out.print(s3);
                    }
                }
            }
        }
        // output --> {  "name": {    "first": "Daniel",    "last": "Smith"  },  "age": 45}
    }
}
