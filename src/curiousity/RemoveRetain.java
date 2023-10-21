package curiousity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RemoveRetain {

    public static void main(String[] args) {

        List<String> stringList1 = new ArrayList<>(Arrays.asList("a", "b", "c"));
        List<String> stringList2 = new ArrayList<>(Arrays.asList("a","h","b","g","d","c"));
        List<String> tempStringList1 = new ArrayList<>(Arrays.asList("a", "b", "c"));

        stringList1.retainAll(stringList2);  // stringList1 retain --> a, b, c
        stringList2.retainAll(tempStringList1);  // stringList2 retain --> a, b, c

        // stringList1.removeAll(stringList2);  // stringList1 remove --> []
        // stringList2.removeAll(tempStringList1);  // stringList2 remove --> h, g, d

        System.out.println(stringList1);
        System.out.println(stringList2);

        /** List<String> stringList1 = Arrays.asList("a", "b", "c");
         * stringList1.removeAll(stringList2); --> UnsupportedOperationException
         * because
         *  When you use Arrays.asList, you get a list backed by the actual array passed in with restricted functionality.
         *  If you want a fully modifiable list you have to create a new list like this above.
         * For example:
         *  new ArrayList<>(Arrays.asList("a", "b", "c"));
          */
    }
}
