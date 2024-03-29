package com.codekata.curiousity;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CheckingPathOf {

    public static void main(String[] args) {


        File temp = new File(System.getProperty("user.dir")).getParentFile();

        File letMe = new File(temp, "child-folder");

        System.out.println(letMe);

        final Path workspace = Paths.get("D:", "Workspace");

        final Path childPath = Paths.get("parent-folder", "child-folder");

        System.out.println(workspace.resolve(childPath));

        String userDir = System.getProperty("user.dir");
        Path workspaceDirectory = Paths.get(userDir);
        final Path projectPath = workspaceDirectory.getParent();

        final Path fullPath = projectPath.resolve(childPath);
        System.out.println(fullPath);

    }
}
