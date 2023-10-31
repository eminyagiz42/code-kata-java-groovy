package curiousity;


public class ExceptionsNotes {

    public static void main(String[] args) {
        try{
            int i = 5 / 0;
        }catch(ArithmeticException ex) {
            System.out.printf("ArithmeticException occured, the reason is %s", ex.getMessage());
        }

        System.out.println();

        try{
            int[] arr = new int[2];
            arr[0] = 9;
            arr[1] = 8;
            System.out.println(arr[2]);
        }catch(IndexOutOfBoundsException ex) {
            System.out.printf("IndexOutOfBoundsException occured, there is not index %s in the array ", ex.getMessage());
        }

        System.out.println();
        try{
            String a = "abx";
            int b = Integer.valueOf(a);
        }catch(NumberFormatException ex) {
            System.out.printf("NumberFormatException occured, the reason is %s ", ex.getMessage());
        }

        try{
            //TODO
        }catch(Exception ex) {
            System.out.printf("Exception occured, the reason is %s ", ex.getMessage());
        }

        try{
            //TODO
        }catch(NullPointerException ex) {
            System.out.printf("NullPointerException occured, the reason is %s ", ex.getMessage());
        }
    }
}
