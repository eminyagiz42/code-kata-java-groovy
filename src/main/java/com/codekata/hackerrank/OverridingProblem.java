package com.codekata.hackerrank;

import java.util.*;
import java.io.*;

public class OverridingProblem {


    // https://www.hackerrank.com/challenges/java-method-overriding-2-super-keyword/problem

    public static void main(String[] args) {
        MotorCycle M = new MotorCycle();
    }
}

//Parent class
class BiCycle {

    String define_me() {
        return "a vehicle with pedals.";
    }

}

class MotorCycle extends BiCycle {

    String define_me() {
        return "a cycle with an engine.";
    }

    MotorCycle() {
        System.out.println("Hello I am a motorcycle, I am " + define_me());


        //We added super keyword to get the method in the parent class
        String temp = super.define_me(); //Fix this line

        System.out.println("My ancestor is a cycle who is " + temp);
    }

}

