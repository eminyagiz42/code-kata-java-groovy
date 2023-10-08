package leetcode;

class CanPlaceFlower {

	public static void main(String[] args) {

		// https://leetcode.com/problems/can-place-flowers/

		int[] flowerbed = {0,0,1,0,0,0,0,1,0,1,0,0,0,1,0,0,1,0,1,0,1,0,0,0,1,0,1,0,1,0,0,1,0,0,0,0,0,1,0,1,0,0,0,1,0,0,1,0,0,0,1,0,0,1,0,0,1,0,0,0,1,0,0,0,0,1,0,0,1,0,0,0,0,1,0,0,0,1,0,1,0,0,0,0,0,0};
		//int[] flowerbed = { 0,1,1};
		//int[] flowerbed = {1,0,0,0,1};
		//int[] flowerbed = { 0, 1, 0, 1, 0, 1, 0, 0 };
		//[0,0,1,0,1], [0,1,0,1,0,1,0,0]
		System.out.println(canPlaceFlowers(flowerbed, 17));
	}

	public static boolean canPlaceFlowers(int[] flowerbed, int n) {
		if (flowerbed.length == 1 && flowerbed[0] == 0) {
			if (n == 1 || n == 0) {
				return true;
			}
		}
		int corner2Zero = placeCorner2Zero(flowerbed);
		int counter3Zero = 0;
		for (int i = 0; i < flowerbed.length - 1; i++) {
			if (i > 0 && flowerbed[i - 1] == 0 && flowerbed[i] == 0 && flowerbed[i + 1] == 0) {
				counter3Zero++;
				flowerbed[i] = 1;
			}
		}
		return (corner2Zero + counter3Zero) >= n;
	}

	private static int placeCorner2Zero(int[] flowerbed) {
		int corner2Zero = 0;

		if (flowerbed[0] == 0 && flowerbed[1] == 0) {
			corner2Zero++;
			flowerbed[0] = 1;
		}
		if (flowerbed[flowerbed.length - 1] == 0 && flowerbed[flowerbed.length - 2] == 0) {
			corner2Zero++;
			flowerbed[flowerbed.length - 1] = 1;
		}
		return corner2Zero;
	}
}