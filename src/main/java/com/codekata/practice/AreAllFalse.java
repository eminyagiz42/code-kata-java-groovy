package com.codekata.practice;

/**
 * The type Are all false.
 */
public class AreAllFalse {

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
		
		boolean a = false;
		boolean b = true;
		boolean c = true;
		boolean d = true;
		
		if (a || b || c || d) {
			System.out.print("true");
		}else {
			System.out.println("FALSE");
		}

		if (areAllFalse(a, b, c, d)) {
			System.out.println("THE Result");
		}
	}

    /**
     * Are all false boolean.
     *
     * @param a the a
     * @param b the b
     * @param c the c
     * @param d the d
     * @return the boolean
     */
    public static boolean areAllFalse(boolean a, boolean b, boolean c, boolean d){
	    for(boolean x : new Boolean[] { a, b, c, d }) {
	    	if(x) {
	    		return Boolean.FALSE;
	    	}
	    }
	    return Boolean.TRUE;
	}

}
