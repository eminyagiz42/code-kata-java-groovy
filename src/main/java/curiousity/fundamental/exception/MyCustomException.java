package curiousity.fundamental.exception;

public class MyCustomException extends Exception {

    public MyCustomException() {
    }

    MyCustomException(String str) {
        super(str);
    }
}
