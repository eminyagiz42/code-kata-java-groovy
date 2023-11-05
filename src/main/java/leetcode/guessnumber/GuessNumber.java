package leetcode.guessnumber;

public class GuessNumber extends GuessGame {

    public static void main(String[] args) {

        //https://leetcode.com/problems/guess-number-higher-or-lower

        System.out.println(guessNumber(4));
    }

    /**
     * Forward declaration of guess API.
     *
     * @param n
     *               guess num
     * @return -1 if guess num >  n
     * 0 if guess num == n
     * 1 if guess num <  n
     */
    public static int guessNumber(int n) {
        int l = 1;
        int r = n;
        while (l < r) {
            final int m = l + (r - l) / 2;
            if (guess(m) <= 0) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        return l;
    }

}
