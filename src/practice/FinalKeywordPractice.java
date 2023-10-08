package practice;

public class FinalKeywordPractice {

	String x = "3";
	String y = "4";
	

	
	public FinalKeywordPractice(String x, String y) {
		
		this.x = x;
		this.y = y;
	}

	public static void main(String[] args) {

		final String a = "test";
		
		FinalKeywordPractice practice2 = new FinalKeywordPractice("5","6");
		System.out.print(practice2.useThis());

	}
	
	public String useThis() {
		return this.printThem();	
	}
	
	
	public String printThem() {
		FinalKeywordPractice practice = new FinalKeywordPractice("7","8");
		if ( this == practice) {
			return "same Model ?";
		//} else if ( this.x == practice.x) {
		//	return "same variable";
		}else if ( this.toString() == practice.toString()) {
			return "same when string";
		}
		//return this.toString() + " and " + practice.toString() ;
		//return this.x + " and " + this.y ; // 7 and 8
		return practice.x + " and " + practice.y ; // 5 and 6
		
	}

}
