package curiousity;

public class LoopPlusPlus {

    public static void main(String[] args) {

        for (int i = 0; i < 5; ++i) {
            System.out.println("i = " + ++i);
        }
        /* ++i (Plus plus BEFORE means, BEFORE the line, do i = i + 1;)
                i = 1
                i = 3
                i = 5
         */

        for (int j = 0; j < 5; j++) {
            System.out.println("j = " + j++);
        }

        /* j++ (Plus plus AFTER means, AFTER the line, do j = j + 1;)
                j = 0
                j = 2
                j = 4
         */
    }
}
