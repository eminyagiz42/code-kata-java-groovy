package practice;

public class AreAllFalse {

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


		if (areAllFalse(a,b,c,d)) {
			System.out.println("THE Result");
		}
		
	}
	
	public static boolean areAllFalse(boolean a, boolean b, boolean c, boolean d){
	    for(boolean x : new Boolean[] { a, b, c, d }) {
	    	if(x) {
	    		return Boolean.FALSE;
	    	}
	    }
	    return Boolean.TRUE;
	}

}
