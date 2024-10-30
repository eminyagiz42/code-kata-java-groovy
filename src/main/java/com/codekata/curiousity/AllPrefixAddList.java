package com.codekata.curiousity;

import java.util.ArrayList;
import java.util.List;

public class AllPrefixAddList {

    public static void main(String[] args) {
        List<String> allProduct = new ArrayList<>();
        allProduct.add("aaa");
        allProduct.add("aaa");
        allProduct.add("aaa");
        allProduct.add("aaa");
        allProduct.add("aaa");

        /*
        for (int i = 0; i < allProduct.size(); i++) {
            allProduct.set(i, "siteURL" +allProduct.get(i));
        }
        */

        allProduct.replaceAll(s -> "siteURL" + s);

        System.out.println(allProduct);

        //Result:
        // [siteURLaaa, siteURLaaa, siteURLaaa, siteURLaaa, siteURLaaa]
    }
}
