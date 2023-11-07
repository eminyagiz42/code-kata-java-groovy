package curiousity.fundamental.collection;

import java.util.*;

public class CollectionNotes {

    public static void main(String[] args) {
        // arrayPractice();
        // arrayListPractice();
        ListPractice();
        hashtablePractice();
        setPractice();
        // linkedListPractice();
        // hashMapPractice();
        hashSetPractice();
        stackPractice();
        queuePractice();
    }

    public static void arrayPractice() {
        int[] integerArray = new int[5];
        integerArray[0] = 10;
        integerArray[1] = 20;
        integerArray[2] = 30;
        integerArray[3] = 40;
        integerArray[4] = 50;
        for (int i = 0; i < integerArray.length; i++) {
            System.out.println("Element at index " + i + " : " + integerArray[i]);
        }

        int[] initializedIntArray = new int[]{ 1,2,3,4,5,6,7,8,9,10 };
        for (int value : initializedIntArray ) {
            System.out.print(value + ",");
        }
        System.out.println();

        int[][] arr = { { 2, 7, 9 }, { 3, 6, 1 }, { 7, 4, 2 } };
        for (int i = 0; i < 3; i++) {// printing 2D array
            for (int j = 0; j < 3; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }


        int[][] cloneArray = arr.clone();
        System.out.println(arr == cloneArray); // false
        System.out.println(arr[0] == cloneArray[0]); // true
    }

    public static void arrayListPractice() {

        // Raw
        ArrayList arrayList = new ArrayList();
        arrayList.add("1");
        arrayList.add(1);
        arrayList.add('c');
        System.out.println(arrayList);

        arrayList.clear();
        System.out.println("after clear : " + arrayList);

        //String ArrayList
        ArrayList<String> stringArrayList = new ArrayList();
        stringArrayList.add("abc");
        stringArrayList.add("def");
        stringArrayList.add("ghj");
        System.out.println(stringArrayList);

        stringArrayList.remove("def");
        System.out.println("after \"def\" removed: " + stringArrayList);

        if (stringArrayList.contains("abc")){
            System.out.println("yes "+ stringArrayList + " contains \"abc\" ");
        }

        System.out.println("index of \"ghj\" is " + stringArrayList.indexOf("ghj"));

        stringArrayList.forEach(s -> {
            for (char c : s.toCharArray()) {
                System.out.print(c + ",");
            }
            System.out.println("");
        });
    }

    public static void ListPractice() {
        List<Integer> integerList = new ArrayList<>();

    }

    public static void setPractice() {
        Set exampleleSet = new HashSet();

    }

    public static void hashtablePractice() {
        Hashtable exampleTable = new Hashtable();

    }

    public static void linkedListPractice() {
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("Emin");
        linkedList.add("Fatma");
        linkedList.add("Ahmet");
        linkedList.add("Zehra");

        System.out.println(linkedList.getFirst()); // Emin
        System.out.println(linkedList.getLast()); // Zehra

        for (String current : linkedList) {
            if ("Ahmet".equals(current)) {
                System.out.println("We found = " + current);
            }
        }

        Iterator<String> iterator = linkedList.iterator();
        while (iterator.hasNext()) {
            String next =  iterator.next();
            if (next.length() < 5) { // Emin removed from linkedList
                iterator.remove();
            }
        }

        System.out.println(linkedList);
    }

    public static void hashMapPractice() {
        HashMap<Character, Integer> hashMap = new HashMap<>();
        hashMap.put('a', 42);
        hashMap.put('b', 13);
        hashMap.put('c', 29);

        System.out.println(hashMap.get('c').intValue());
        hashMap.remove('b');
        System.out.println(hashMap); // {a=42, c=29}

        hashMap.containsKey('a'); // true
        hashMap.containsValue(29); // true

        hashMap.keySet(); // all keys
        hashMap.values(); // all values
    }

    public static void hashSetPractice() {

        HashSet<Integer> numberHashSet = new HashSet<>(); // is sorts based on numberHashSet.hashCode()
        numberHashSet.add(4);
        numberHashSet.add(1);
        numberHashSet.add(3);
        numberHashSet.add(2);

        System.out.println(numberHashSet); // [1, 2, 3, 4]

        Iterator<Integer> iterator = numberHashSet.iterator();

        while (iterator.hasNext()) { // 1234
            System.out.print(iterator.next());
        }
    }

    public static void stackPractice() {
        System.out.println("\nStack Notes :");
        System.out.println();
        Stack<String> games = new Stack<>();
        games.add("prince of persia"); //bottom
        games.add("mario");
        games.add("tetris");           //top

        System.out.println(games.peek());// tetris (top)
        System.out.println(games);       // [prince of persia, mario, tetris]


        System.out.println(games.pop()); //   tetris
        System.out.println(games.pop()); //   mario
        System.out.println(games.pop()); //   prince of persia
        System.out.println(games);       //   []
    }

    public static void queuePractice() {
        System.out.println("\nQueue Notes :");
        System.out.println();

        Queue<String> stringQueue = new LinkedList<>();
        stringQueue.add("number 1");
        stringQueue.add("number 2");
        stringQueue.add("number 3");
        stringQueue.add("number 4");

        System.out.println(stringQueue.peek()); //number 1
        System.out.println(stringQueue);        //[number 1, number 2, number 3, number 4]

        System.out.println(stringQueue.poll());//number 1
        System.out.println(stringQueue);       //[number 2, number 3, number 4]
    }
}
