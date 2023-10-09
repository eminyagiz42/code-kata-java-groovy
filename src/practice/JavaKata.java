package practice;

import java.util.ArrayList;

public class JavaKata {

	public static void main(String[] args) {

		String a1 = "john"; String b1 = "tom";
		String a2 = "john"; String b2 = "mary";
		String a3 = "john"; String b3 = "tom";
		String a4 = "mary"; String b4 = "anna";
		String a5 = "mary"; String b5 = "anna";


		String [] pair_left = {a1,a2,a3,a4,a5};
		String [] pair_right = {b1,b2,b3,b4,b5};

		ArrayList arrList = new ArrayList<String>();

		for (int i =0 ; i < pair_left.length; i++) {
			arrList.add(pair_left[i] + " " +  pair_right[i]);
		}

		int sum = 1;
		System.out.println(sum);
		for (int i =2 ; i < arrList.size(); i++) {
			for (int j =0 ; j < i; j++) {
				if(arrList.get(i).equals(arrList.get(j)) ){
					sum++;

				}
			}
			System.out.println(sum);
		}
	}

}
