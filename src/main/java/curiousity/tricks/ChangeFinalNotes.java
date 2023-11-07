package curiousity.tricks;

public class ChangeFinalNotes {

    static final int CONSTANT_NUMBER = 8;

    public static void main(String[] args) {
        ChangeFinal changeFinal = new ChangeFinal();
        System.out.println(changeFinal.getUpdateMe());

        //CONSTANT_NUMBER = 3; Cannot assign a value to final variable 'CONSTANT_NUMBER'
    }
}
