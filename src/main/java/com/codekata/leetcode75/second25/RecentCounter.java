package com.codekata.leetcode75.second25;

/**
 * The type Recent counter.
 */
public class RecentCounter {

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {

        //https://leetcode.com/problems/number-of-recent-calls

        //String[] strings = {"RecentCounter", "ping", "ping", "ping", "ping"};

        RecentCounter obj = new RecentCounter();
        int[] p = {1,100,3001,3002};
        for (int t : p ) {
            int ans = obj.ping(t);
            System.out.print(ans + " ");
        }
    }

    /**
     * The Ar.
     */
//Solution 1
    int[] ar;
    /**
     * The L.
     */
    int l=0, /**
     * The R.
     */
    r=0;

    /**
     * Instantiates a new Recent counter.
     */
    public RecentCounter() {
        ar=new int[10000];
    }

    /**
     * Ping int.
     *
     * @param t the t
     * @return the int
     */
    public int ping(int t) {
        ar[r++]=t;
        while(t-ar[l]>3000)
            l++;
        return r-l;
    }

    /* Solution 2
    private int[] s = new int[10010];
    private int idx;

    public RecentCounter() {
    }

    public int ping(int t) {
        s[idx++] = t;
        return idx - search(t - 3000);
    }

    private int search(int x) {
        int left = 0, right = idx;
        while (left < right) {
            int mid = (left + right) >> 1;
            if (s[mid] >= x) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
     */
}

