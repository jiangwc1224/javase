package java.com.jwc.lambda;

import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class LambdaDemo001 {
	public static void main(String[] args) {
		// 一个输出
		Supplier<String> supplier = () -> {return "1";};
		Supplier<String> supplier2 = () -> "2";
		
		System.out.println(supplier.get());
		System.out.println(supplier2.get());
		
		//一个输入
		Consumer<String> consumer = (a) ->System.out.println(a);
		Consumer<String> consumer2 = System.out::println;
		consumer.accept("Consumer   Test1");
		consumer2.accept("Consumer   Test2");
		
		//一个输入一个输出
		Function<String, Integer> function1 = (a) -> {return a.length();};
		Function<String, Integer> function2 = (a) -> a.length();
		System.out.println(function1.apply("abc"));
		System.out.println(function2.apply("abcd"));
		
		//两个输入一个输出
		BiFunction<String, String, Integer> biFunction1 = (a,b) -> {return a.length()+b.length();};
		BiFunction<String, String, Integer> biFunction2 = (a,b) -> a.length()+b.length();
		System.out.println(biFunction1.apply("abcd","ccc"));
		System.out.println(biFunction2.apply("abcde","hihi"));
	}
}
