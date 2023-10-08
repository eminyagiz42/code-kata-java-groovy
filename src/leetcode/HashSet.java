package leetcode;

import java.util.ArrayList;

public class HashSet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String a1 = "john"; String b1 = "tom";
		String a2 = "john"; String b2 = "mary";
		String a3 = "john"; String b3 = "tom";
		String a4 = "mary"; String b4 = "anna";
		String a5 = "mary"; String b5 = "anna";
		String a6 = "mary"; String b6 = "anna";
		String a7 = "mary"; String b7 = "anna";
		
		
	
        String [] pair_left = {a1,a2,a3,a4,a5,a6,a7};
        String [] pair_right = {b1,b2,b3,b4,b5,b6,b7};
        
        ArrayList arrList = new ArrayList<String>();
        
        for (int i =1 ; i < pair_left.length; i++) {
        	arrList.add(pair_left[i] + " " +  pair_right[i]);
        	
        }
        
        int sum = 1;
        System.out.println(sum);
        
        for (int i =1 ; i < arrList.size()-1; i++) {
        	
        	 for (int j =0 ; j < i; j++) {
                 if(arrList.get(i) == arrList.get(j) ){
                 	sum++;
                     System.out.println(sum);
                 }
        	 }
        	
        	  System.out.println(i);
        	

        }
    
        
/*
        int sum = 1;
        System.out.print(sum);
        for (int i =1 ; i < pair_left.length; i++) {
            if((pair_left[i] + " " + pair_right[i]) == (pair_left[i-1] + " " + pair_right[i-1])){
            	sum++;
                System.out.print(sum);
            }
        }
        */
		
	}

}
