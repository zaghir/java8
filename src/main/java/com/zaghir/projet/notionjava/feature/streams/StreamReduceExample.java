package com.zaghir.projet.notionjava.feature.streams;

import java.util.Arrays;
import java.util.List;

public class StreamReduceExample {

	public static void main(String[] args) {
		
		List<Integer> listOfIntegers = Arrays.asList(1,2,3,4,5);
		
		int sum = listOfIntegers.stream()
				.mapToInt(i -> i )
				.sum();
		System.out.println("Sum Result : "+sum);
		System.out.println(listOfIntegers.stream().mapToInt(i -> i).count());
		// 1 * 1 =1    1*2 =2    2*3 =6   6*4 =24    24*5 =120 
 		System.out.println("Result of Multiplication : "+ listOfIntegers.stream().reduce(1 , (a,b)-> a*b));
 		
 		System.out.println("Result of Addition : "+ listOfIntegers.stream().reduce(0 , (a,b)-> a+b)); ;
 		
 		
	}

}
