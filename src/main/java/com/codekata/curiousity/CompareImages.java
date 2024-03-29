package com.codekata.curiousity;

import net.datafaker.providers.entertainment.SouthPark;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

public class CompareImages {

    public static void main(String[] args) {
        File inputLogo = new File("");
        File currentLogo = new File("");


        if (!inputLogo.exists()) {
            System.out.println("Input image File not found: " + inputLogo.getAbsolutePath());
        }

        if (!currentLogo.exists()) {
            System.out.println("Current image File not found: " + currentLogo.getAbsolutePath());
        }

        if (!compareTwoImages(inputLogo, currentLogo)) {
            System.out.println("not same picture");
        } else {
            System.out.println("yes it is same");
        }
    }


    public static boolean compareTwoImages(final File file1, final File file2) {
        try {
            BufferedImage img1 = ImageIO.read(file1);
            BufferedImage img2 = ImageIO.read(file2);

            for (int x = 0; x < img1.getWidth(); x++) {
                for (int y = 0; y < img1.getHeight(); y++) {
                    if (img1.getRGB(x, y) != img2.getRGB(x, y)) {
                        return false;
                    }
                }
            }
        } catch (Exception ex) {
            System.out.println("Failed to compare image files ...");
        }
        return true;
    }
}
