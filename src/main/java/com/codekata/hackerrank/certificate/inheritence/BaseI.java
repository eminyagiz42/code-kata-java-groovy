package com.codekata.hackerrank.certificate.inheritence;

public interface BaseI {
    void method();
}

class BaseC {
    public void method(){
        System.out.println("Inside BaseC::method");
    }
}

class ImplC extends  BaseC implements BaseI {
    public static void main(String[] args) {
        (new ImplC()).method();
    }

}

/* Her ***** */

/*
This one is wrong
/* this /* mor */   //This comment line is temporary, the right one star-slash gives error//     */


