package com.codekata.hackerrank.problemsolving.grade;


import java.io.IOException;
import java.util.Arrays;
import java.util.List;


public class GradingStudents {

    //https://www.hackerrank.com/challenges/grading/problem?isFullScreen=true

    public static void main(String[] args) throws IOException {
        /*
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        int gradesCount = Integer.parseInt(bufferedReader.readLine().trim());
        List<Integer> grades = IntStream.range(0, gradesCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(toList());
        List<Integer> result = Result.gradingStudents(grades);
        bufferedWriter.write(
                result.stream()
                        .map(Object::toString)
                        .collect(joining("\n"))
                        + "\n"
        );
        bufferedReader.close();
        bufferedWriter.close();
        */

        List<Integer> grades = Arrays.asList(73, 67, 38, 33);
        List<Integer> result = Result.gradingStudents(grades);
        System.out.println(result);
    }
}


class Result {

    /*
     * Complete the 'gradingStudents' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY grades as parameter.
     */
    public static List<Integer> gradingStudents(List<Integer> grades) {
        for (int i = 0; i < grades.size(); i++) {
            final Integer grade = grades.get(i);
            if (grade > 35) {
                if ((grade + 1) % 5 == 0) {
                    grades.set(i, grade + 1);
                } else if ((grade + 2) % 5 == 0) {
                    grades.set(i, grade + 2);
                }
            }
        }
        return grades;
    }

}

