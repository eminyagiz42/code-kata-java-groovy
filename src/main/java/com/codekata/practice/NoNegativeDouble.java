package com.codekata.practice;

public class NoNegativeDouble {

	public static void main(String[] args) {
		
		Double test1 = 0.0;
		Double test2 = null;
		Double test3 = 3.6;
		Double test4 = -5.6;
		
		NoNegativeDoubleModel model = new NoNegativeDoubleModel();
		
		model.setAvailableQuantity(Math.max(0, test1));
		System.out.println("Test 1:" + model.getAvailableQuantity());
		
		if (test2 != null) { // throws null pointer exception
		model.setAvailableQuantity(Math.max(0, test2));
		System.out.println("Test 2:" + model.getAvailableQuantity());
		}
		
		model.setAvailableQuantity(Math.max(0, test3));
		System.out.println("Test 3:" + model.getAvailableQuantity());
		
		model.setAvailableQuantity(Math.max(0, test4));
		System.out.println("Test 4:" + model.getAvailableQuantity());
		
	}

}
