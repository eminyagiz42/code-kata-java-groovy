package com.codekata.curiousity;

import java.util.Scanner;

public class FilePathInvestigation {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String t = sc.nextLine();

        System.out.println(getFilePath(t));
        //input:
        //D:\Workspace\b2b-fast-track-template\novarto-logo.jpg
        //output:
        //D:\\Workspace/b2b-fast-track-template/novarto-logo.jpg

    }

    private static String getFilePath(String path) {
        return path.replace("\\", "/").replace(":/", ":\\\\");
    }
}
