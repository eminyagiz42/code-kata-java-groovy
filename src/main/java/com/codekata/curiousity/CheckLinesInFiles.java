package com.codekata.curiousity;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;

public class CheckLinesInFiles {

    public static void main(String[] args) throws IOException {
        String inputCustomFontName = "";
        String inputCustomFontUrl = "";
        File currentFontFile = new File("");

        final String currentFontFileLines = FileUtils.readLines(currentFontFile, Charset.forName("windows-1252")).toString();

        if (currentFontFileLines.contains(inputCustomFontName)) {
            System.out.println("check it");
        }

    }
}
