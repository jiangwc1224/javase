package java.com.jwc.lambda;

import java.util.function.Function;

public class LambdaDemo002 {
	
	private String toUpperCase(String str) {
		return str.toUpperCase();
	}
	
	private static String toLowerCase(String str) {
		return str.toLowerCase();
	}
	
	public static void main(String[] args) {
		Function<String, String> f1 =(str)-> {return new LambdaDemo002().toUpperCase(str);};
		Function<String, String> f2 =(str)->new LambdaDemo002().toUpperCase(str);
		Function<String, String> f3 =new LambdaDemo002() :: toUpperCase;
		
		System.out.println(f1.apply("abcdefg"));
		System.out.println(f2.apply("abcdefg"));
		System.out.println(f3.apply("abcdefg"));
		
		
		Function<String, String> f4 =(str)-> {return LambdaDemo002.toLowerCase(str);};
		Function<String, String> f5 =(str)->LambdaDemo002.toLowerCase(str);
		Function<String, String> f6 =LambdaDemo002 :: toLowerCase;
		
		System.out.println(f4.apply("ABCDE"));
		System.out.println(f5.apply("ABCDE"));
		System.out.println(f6.apply("ABCDE"));
	}
	
	
}
