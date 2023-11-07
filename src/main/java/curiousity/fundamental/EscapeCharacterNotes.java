package curiousity.fundamental;

public class EscapeCharacterNotes {

    public static void main(String[] args) {

        // \" question mark
        // \\ backslash
        // \t tab
        // \n new line

        System.out.print("\"The roses are red\\");
        System.out.println("\nViolets are blue\\");
        System.out.print("The stars shine\\");
        System.out.println("\nBright but not as\\");
        System.out.println("Bright as \t you do\"\"");

        /** Output
         * "The roses are red\
         * Violets are blue\
         * The stars shine\
         * Bright but not as\
         * Bright as 	 you do""
         */

    }
}
