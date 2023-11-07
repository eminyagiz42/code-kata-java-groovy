package curiousity.fundamental.collection;

import java.util.ArrayList;
import java.util.List;

public class ObjectListNotes {

    static int globalInteger = 123;
    int getGlobalButNotStatic = 987;

    public static void main(String[] args) {
        Animal monkey = new Animal(3, "brown");
        Animal zebra = new Animal();
        zebra.setAge(5);
        zebra.setColor("black-white");
        Animal[] animalsAge = {monkey, zebra};

        for (Animal animal : animalsAge) {
            System.out.println(animal.getAge());
        }

        System.out.println();
        List<Animal> animalList = new ArrayList<>();
        animalList.add(monkey);
        animalList.add(zebra);
        for (Animal animal : animalList) {
            System.out.println("animal = " + animal.getAge());
        }

        System.out.println();
        System.out.println("globalInteger = " + globalInteger); // Static: it belongs to class itself
        ObjectListNotes objectList = new ObjectListNotes();// Non-Static : Instance of class
        System.out.println("getGlobalButNotStatic = " + objectList.getGlobalButNotStatic);
    }
}
