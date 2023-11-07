package com.codekata.practice;

public class NoDoubleNoNegative {

	public static void main(String[] args) {

		Double getAvailableQuantity = 7.9;

		System.out.print( extracted(getAvailableQuantity));
	}

	private static Double extracted(Double getAvailableQuantity) {
		if (getAvailableQuantity != null) {
			final int availableQuantity = getAvailableQuantity.intValue();
			if (availableQuantity <= 0) {
				return 0.0;
			} else {
				return (double) availableQuantity;
			}
		}
		return null;
	}
	
	

}
