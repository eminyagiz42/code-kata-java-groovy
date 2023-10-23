package curiousity;

import java.util.ArrayList;

public class CollectionTypes {

    public static void main(String[] args) {
        arrayPractice();
        arrayListPractice();
        hashMapPractice();
        hashSetPractice();
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
        System.out.println("after clear : " +arrayList);

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

    public static void hashMapPractice() {

    }

    public static void hashSetPractice() {

    }
}
