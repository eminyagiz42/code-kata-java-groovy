package com.codekata.practice;

/**
 * The type No double no negative.
 */
public class NoDoubleNoNegative {

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
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
