package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class KeysAndRooms {

    public static void main(String[] args) {

        // https://leetcode.com/problems/keys-and-rooms/

        List<List<Integer>> rooms = new ArrayList<>();
        List<Integer> key0 = Arrays.asList(1,3);
        List<Integer> key1 = Arrays.asList(3,0,1);
        List<Integer> key2 = Collections.singletonList(2);
        List<Integer> key3 = Collections.singletonList(0);
        rooms.add(key0);
        rooms.add(key1);
        rooms.add(key2);
        rooms.add(key3);

        System.out.println(canVisitAllRooms(rooms));
    }

    public static boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int[] foundKeys = new int[rooms.size()];
        depthFirstSearch(rooms, 0, foundKeys);
        return Arrays.stream(foundKeys).allMatch(a -> a == 1);
    }

    private static void depthFirstSearch(List<List<Integer>> rooms, int node, int[] foundKeys) {
        foundKeys[node] = 1;
        for (final int child : rooms.get(node)){
            if (foundKeys[child] == 0) {
                depthFirstSearch(rooms, child, foundKeys);
            }
        }
    }

}

