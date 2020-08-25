package com.zaghir.projet.notionjava.feature;

import java.util.stream.IntStream;

public class Java7VsJava8Example2 {

	public static void main(String[] args) {
		
		// Before 
		int total= 0 ; 
		
		for(int i = 0 ; i <=50 ; i++) {
			total += i ;
		}
		
		System.out.println("Total is = "+total);
		
		// After
		int total1 = 0 ;
		
		total1 = IntStream.rangeClosed(0, 50)
				.map(Integer :: new)
				.sum();
		
		System.out.println("Total in java8 is = "+total1);
				

	}

}
