package leetcode;

class MaxVowels {

	public static void main(String[] args) {

		// https://leetcode.com/problems/maximum-number-of-vowels-in-a-substring-of-given-length

		String s = "abciiidef";
		int k = 3;
		System.out.println(maxVowels(s, k));

	}
	public static int maxVowels(String s, int k) { //1ms
		int t = 0, n = s.length();
		for (int i = 0; i < k; ++i) {
			if (isVowel(s.charAt(i))) {
				++t;
			}
		}
		int ans = t;
		for (int i = k; i < n; ++i) {
			if (isVowel(s.charAt(i))) {
				++t;
			}
			if (isVowel(s.charAt(i - k))) {
				--t;
			}
			ans = Math.max(ans, t);
		}
		return ans;
	}

	private static boolean isVowel(char c) {
		return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
	}

	/*
	private static final Set<Character> vowels = Set.of('a','e','i','o','u');

	public static int maxVowelsSlow(String s, int k) { //28ms
		int t = 0, n = s.length();
		for (int i = 0; i < k; ++i) {
			if (vowels.contains(s.charAt(i))) {
				++t;
			}
		}
		int ans = t;
		for (int i = k; i < n; ++i) {
			if (vowels.contains(s.charAt(i))) {
				++t;
			}
			if (vowels.contains(s.charAt(i - k))) {
				--t;
			}
			ans = Math.max(ans, t);
		}
		return ans;
	}

	 */
}