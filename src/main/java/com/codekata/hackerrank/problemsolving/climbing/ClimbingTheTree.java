package com.codekata.hackerrank.problemsolving.climbing;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;


public class ClimbingTheTree {

    //https://www.hackerrank.com/challenges/climbing-the-leaderboard/problem?isFullScreen=true

    public static void main(String[] args) throws IOException {
        /*
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        int rankedCount = Integer.parseInt(bufferedReader.readLine().trim());
        String[] rankedTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
        List<Integer> ranked = new ArrayList<>();
        for (int i = 0; i < rankedCount; i++) {
            int rankedItem = Integer.parseInt(rankedTemp[i]);
            ranked.add(rankedItem);
        }
        int playerCount = Integer.parseInt(bufferedReader.readLine().trim());
        String[] playerTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
        List<Integer> player = new ArrayList<>();
        for (int i = 0; i < playerCount; i++) {
            int playerItem = Integer.parseInt(playerTemp[i]);
            player.add(playerItem);
        }
        bufferedReader.close();
        List<Integer> result = Result.climbingLeaderboard(ranked, player);
        System.out.println(result);
        /*
        for (int i = 0; i < result.size(); i++) {
            bufferedWriter.write(String.valueOf(result.get(i)));

            if (i != result.size() - 1) {
                bufferedWriter.write("\n");
            }
        }
        bufferedWriter.newLine();
        bufferedWriter.close();
        */

        //List<Integer> ranked = Arrays.asList(100, 100, 50, 40, 40, 20, 10);
        //List<Integer> player = Arrays.asList(5, 25, 50, 120); // 6, 4, 2, 1

        List<Integer> ranked = Arrays.asList(100, 90, 90, 80, 75, 60);
        List<Integer> player = Arrays.asList(50, 65, 77, 90, 102); // 6, 5, 4, 2, 1
        List<Integer> result = Result.climbingLeaderboard(ranked, player);
        System.out.println(result);
    }
}

class Result {

    /*
     * Complete the 'climbingLeaderboard' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY ranked
     *  2. INTEGER_ARRAY player
     */
    public static List<Integer> climbingLeaderboard(List<Integer> ranked, List<Integer> player) {
        int n = ranked.size();
        int m = player.size();

        List<Integer> res = new ArrayList<>();
        List<Integer> rank = new ArrayList<>();

        rank.add(0, 1);

        for (int i = 1; i < n; i++) {
            if (ranked.get(i) == ranked.get(i - 1)) {
                ranked.add(i, ranked.get(i - 1));
            } else {
                rank.add(i, rank.get(i - 1) + 1);
            }
        }

        for (int i = 0; i < m; i++) {
            int score = player.get(i);
            if (score > ranked.get(0)) {
                res.add(i, 1);
            } else if (score < ranked.get(n - 1)) {
                res.add(i, rank.get(n - 1) + 1);
            } else {
                int index = binarySearch(ranked, score);
                res.add(i, rank.get(index));

            }
        }
        return res;

    }

    private static int binarySearch(List<Integer> a, int key) {

        int lo = 0;
        int hi = a.size() - 1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (a.get(mid) == key) {
                return mid;
            } else if (a.get(mid) < key && key < a.get(mid - 1)) {
                return mid;
            } else if (a.get(mid) > key && key >= a.get(mid + 1)) {
                return mid + 1;
            } else if (a.get(mid) < key) {
                hi = mid - 1;
            } else if (a.get(mid) > key) {
                lo = mid + 1;
            }
        }
        return -1;
    }


    public static List<Integer> climbingLeaderboard4(List<Integer> ranked, List<Integer> player) {
        final List<List<Integer>> rankAndOrderList = getRankAndOrderList(ranked);

        List<Integer> result = new ArrayList<>();

        for (int play : player) {
            for (List<Integer> rankOrder : rankAndOrderList) {
                if (Math.max(rankOrder.get(0), play) == play) {
                    if (play > rankAndOrderList.get(0).get(0)) {
                        result.add(1);
                    } else {
                        result.add(rankOrder.get(1));
                    }
                    break;
                }
            }
        }

        return result;
    }


    public static List<Integer> climbingLeaderboard23(List<Integer> ranked, List<Integer> player) { //It exceeds the timeout
        final List<List<Integer>> rankAndOrderList = getRankAndOrderList(ranked);
        List<Integer> result = new ArrayList<>();

        for (int play : player) {
            for (List<Integer> rankOrder : rankAndOrderList) {
                if (Math.max(rankOrder.get(0), play) == play) {
                    if (play > rankAndOrderList.get(0).get(0)) {
                        result.add(1);
                    } else {
                        result.add(rankOrder.get(1));
                    }
                    break;
                }
            }
        }

        return result;
    }

    private static List<List<Integer>> getRankAndOrderList(List<Integer> ranked) {
        List<List<Integer>> rankAndOrder = new ArrayList<>();

        int index = 1;
        if (ranked.size() > 1 && ranked.get(0).equals(ranked.get(1))) {
            rankAndOrder.add(Arrays.asList(ranked.get(0), index));
        }

        for (int i = 1; i < ranked.size(); i++) {
            if (!ranked.get(i).equals(ranked.get(i - 1))) {
                index++;
            }
            rankAndOrder.add(Arrays.asList(ranked.get(i), index));
        }

        rankAndOrder.add(Arrays.asList(0, ++index));
        return rankAndOrder;
    }

    private static int findMeBinary(int[] nums, int target, int start, int end) {
        if (start > end) {
            return -1;
        }

        final int middle = ((int) Math.floor((start + end) / 2));

        if (nums[middle] == target) {
            return middle;
        }
        if (nums[middle] > target) {
            return findMeBinary(nums, target, start, middle - 1);
        }
        if (nums[middle] < target) {
            return findMeBinary(nums, target, middle + 1, end);
        } else {
            return -1;
        }
    }


    public static List<Integer> climbingLeaderboardWay(List<Integer> ranked, List<Integer> player) {
        List<Integer> result = new ArrayList<Integer>();
        TreeMap<Integer, Integer> rankMap = new TreeMap<Integer, Integer>();

        // Assertion: The Ranked List is already sorted in descending order
        // Derive the Rank for each Score and store it in a Sorted Map i.e., TreeMap
        int count=0;
        for(int value : ranked){
            if(!rankMap.containsKey(value)){
                count++;
                rankMap.put(value, count);
            }
        }

        System.out.println(rankMap);

        for(int score : player){
            List<Integer> listToRemove = new ArrayList<Integer>();

            // Edge Case: When the score is greater than the Leaderboard
            if(score > rankMap.lastKey()){
                result.add(1);
                continue;
            }

            for(int value : rankMap.keySet()){
                if(score > value){
                    // If the score is greater than the current value on Rank Map,
                    // then we don't need to compare it anymore for any of the scores that come in future
                    listToRemove.add(value);
                }
                else if(score < value){
                    // If the score is lesser than the curren value on Rank Map,
                    // then increment the rank and add it to the list
                    result.add(rankMap.get(value) + 1);
                    break;
                }
                else{
                    // If the score is equal to the curren value on Rank Map,
                    // then add the current rank to the list
                    result.add(rankMap.get(value));
                    break;
                }
            }

            // Remove all the values which are past the current score
            for(int value : listToRemove)
                rankMap.remove(value);
        }

        return result;
    }


}