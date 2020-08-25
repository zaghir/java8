package com.zaghir.projet.notionjava.feature.streams;

import java.util.Arrays;
import java.util.List;

public class StreamLimitExample {

	public static void main(String[] args) {
		
		List<String> fruits = Arrays.asList("Apple","Orange","Graphs" , "Banana" ,"Pineapple") ;		
		fruits
			.stream()
			.limit(2)
			.forEach(System.out::println );
		
		List<Integer> integers = Arrays.asList(1,2,3,4,5,6);
		int sum = integers
			.stream()
			.limit(4)
			.reduce(0 ,(x,y) -> x+y);
		System.out.println("Sum of limit : " + sum);
		
		int skip = integers
				.stream()
				.skip(2)
				.reduce(0 ,(x,y) -> x+y);
			System.out.println("Skip of : " + skip);
		
		
		

	}

}
