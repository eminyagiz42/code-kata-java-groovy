package com.codekata.hackerrank;

import org.apache.commons.lang3.StringUtils;

import java.util.*;

public class SortProblem {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int testCases = Integer.parseInt(in.nextLine());

        List<Student> studentList = new ArrayList<>();
        while (testCases > 0) {
            int id = in.nextInt();
            String fname = in.next();
            double cgpa = in.nextDouble();

            Student st = new Student(id, fname, cgpa);
            studentList.add(st);

            testCases--;
        }

        //we sort it here by custom comparator
        studentList.sort(new StudentSorter());

        for (Student st : studentList) {
            System.out.println(st.getFname());
        }
    }

}


class Student {

    Student(){}

    private int id;
    private String fname;
    private double cgpa;

    public Student(int id, String fname, double cgpa) {
        super();
        this.id = id;
        this.fname = fname;
        this.cgpa = cgpa;
    }

    public int getId() {
        return id;
    }

    public String getFname() {
        return fname;
    }

    public double getCgpa() {
        return cgpa;
    }
}

/**
 * Input:
 * 5
 * 33 Rumpa 3.68
 * 85 Ashis 3.85
 * 56 Samiha 3.75
 * 19 Samara 3.75
 * 22 Fahim 3.76
 */

class StudentSorter implements Comparator<Student> {

    //https://www.hackerrank.com/challenges/java-sort/problem

    @Override
    public int compare(Student o1, Student o2) {
        final int result = -1 * Double.compare(o1.getCgpa(), o2.getCgpa());
        if (result == 0) {
            final int comparedFname = StringUtils.compare(o1.getFname(), o2.getFname());
            if (comparedFname == 0) {
                return Integer.compare(o1.getId(), o2.getId());
            }
            return comparedFname;
        }
        return result;
    }
}