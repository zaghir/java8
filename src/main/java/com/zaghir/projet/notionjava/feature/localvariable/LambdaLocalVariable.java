package com.zaghir.projet.notionjava.feature.localvariable;

import java.util.function.Consumer;

public class LambdaLocalVariable {

	String x ="Hello" ; // instance variable
	
	static int k = 0 ;
	
	public static void main(String[] args) {
		
		int i = 0 ; // this is locale variable 
		
		Consumer<Integer> c1 = (j) -> {
			// i can modifi i 
			// i++ ;
			k = 15 ;
			System.out.println("Print k: " +k);
			System.out.println("Value is :"+(i+j));
		};
		
		
		c1.accept(15);
	}
}
