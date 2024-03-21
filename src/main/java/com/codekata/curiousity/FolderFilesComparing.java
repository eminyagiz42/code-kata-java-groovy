package com.codekata.curiousity;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

public class FolderFilesComparing {

    public static void main(String[] args) {
        File inputCustomBannerFolder = new File("");
        File spaInitialDataDir = new File("");

        File[] inputBannerFolder = inputCustomBannerFolder.listFiles();
        File[] currentBannerFolder = spaInitialDataDir.listFiles();

        for (File languageFolder : inputBannerFolder) {
            for (File inputBanners : languageFolder.listFiles()) {
                for (File currentBanners : currentBannerFolder) {
                    if (inputBanners.getName().equals(currentBanners.getName())) {
                        if (!compareTwoImages(inputBanners, currentBanners)) {
                            System.out.println("input banner and a current banner has same name but different picture!");
                        }
                    }
                }
            }
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
