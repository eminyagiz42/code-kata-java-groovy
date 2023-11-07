package curiousity.tricks;

public class FinalParent { // if a class is final, another class cannot extend it.

    final public void printHello(){ //it's final so, child class cannot override it.
        System.out.println("Hello");
    }
}
