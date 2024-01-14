package groovy.hackerrank.problemsolving.professor

class AngryProfessor {

    //https://www.hackerrank.com/challenges/angry-professor/problem?isFullScreen=true

    static void main(String[] args) {
        System.in.withReader {
            br ->
                int testCases = br.readLine().toInteger()
                testCases.times {
                    List firstLine = br.readLine().tokenize()*.toInteger()
                    int n = firstLine[0]
                    int k = firstLine[1]
                    List a = br.readLine().tokenize()*.toInteger()

                    println angryProfessor(k, a)
                }
        }
    }

    static String angryProfessor(int k, List<Integer> a) {
        int count = 0;
        for (int arrival : a) {
            if (arrival <= 0) {
                count++;
            }
            if (count >= k) {
                return "NO";
            }
        }

        return "YES";
    }
}
