package com.codekata.curiousity.designpattern.factory.impl;

import com.codekata.curiousity.designpattern.factory.Food;

public class Pizza implements Food {
    @Override
    public String getType() {
        return "Someone ordered a Fast Food!";
    }
}







