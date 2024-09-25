package com.codekata.codereview.optional;

import java.util.Optional;

public class OptionalReview {

    public static void main(String[] args) {
        Integer mightBeNull = null;

        int n = mightBeNull != null ? mightBeNull : 1;
        System.out.println(n);

        // Code Review : Handle Nullable Integers as below
        int m = Optional.ofNullable(mightBeNull).orElse(1);
        System.out.println(m);


    }
}
