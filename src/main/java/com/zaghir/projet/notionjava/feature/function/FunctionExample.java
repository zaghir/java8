package com.zaghir.projet.notionjava.feature.function;

import java.util.function.Function;

public class FunctionExample {

	
	static Function<String, String> f1 = name -> name.toUpperCase() ;
	static Function<String, String> f2 = name -> name.toUpperCase().concat(" features") ;
	
	
	public static void main(String[] args) {
//		System.out.println("Result 1 : "+f1.apply("java"));
//		System.out.println("Result 2 : "+f2.apply("java"));
		
		System.out.println("And then Result : "+f1.andThen(f2).apply("java"));
		System.out.println("Compose Result f1.compose(f2) : "+f1.compose(f2).apply("java"));
		System.out.println("Compose Result f2.compose(f1) : "+f2.compose(f1).apply("java"));

	}

}
