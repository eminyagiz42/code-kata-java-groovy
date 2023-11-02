package curiousity.tricks;

public class LargerNumber {

    public static final int EXAMPLE_CONSTANT_VARIABLE = 2;

    public static void main(String[] args) {

        int a = 5, b = 7, largerNum;
        if (a > b) {
            largerNum = a;
        }else {
            largerNum = b;
        }

        //better solution - short if
        largerNum = a > b ? a : b;

        //Even better solution - using existing library
        largerNum = Math.max(a,b);


    }
}
