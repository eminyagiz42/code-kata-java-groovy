package com.codekata;

import java.nio.file.Path;
import java.nio.file.Paths;

public class PathOfHandler {

    public static void main(String[] args) {

        String userDir = System.getProperty("user.dir");
        Path project = Paths.get(userDir);
        final Path parentProjectPath = project.getParent();

        //final String target = ConfigReader.getProperty("need.path");
        //System.out.println(lolo.resolve(Path.of(target)));

        final Path srcFolder = Path.of("src");
        final Path fullPath = parentProjectPath.resolve(srcFolder);
        System.out.println(fullPath.toFile());


    }
}
