package com.codekata.hackerrank.reflection;

import java.lang.reflect.*;
import java.util.*;

public class ReflectionProblem {

    // https://www.hackerrank.com/challenges/java-reflection-attributes/problem

    public static void main(String[] args) throws ClassNotFoundException {

        Class<Student> student = Student.class;
        Method[] methods = student.getDeclaredMethods();

        ArrayList<String> methodList = new ArrayList<>();
        for (Method m : methods){
            methodList.add(m.getName());
        }
        Collections.sort(methodList);
        for (String name : methodList) {
            System.out.println(name);
        }
    }
}


class Student {
    private String name;
    private String id;
    private String email;

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}