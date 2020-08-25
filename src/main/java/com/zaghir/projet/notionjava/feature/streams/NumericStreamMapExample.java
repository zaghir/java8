package com.zaghir.projet.notionjava.feature.streams;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class NumericStreamMapExample {
	
	static double map2Double() {
		return IntStream.rangeClosed(1, 10)       // primitive int elements 
				.mapToDouble(x-> x)               // converting the elements to double
				.sum();                           // performing sum 
	} 
	
	static long map2Long() {
		return IntStream.rangeClosed(1, 10)       // primitive int elements 
				.mapToLong(x-> x)               // converting the elements to long
				.sum();                           // performing sum 
	}
	
	static List<Integer> map2Object() {
		return IntStream.rangeClosed(1, 10)       // primitive int elements 
				.mapToObj(x-> {
					return new Integer(x);
				})
				.collect(Collectors.toList()); 
		/*
		return IntStream.rangeClosed(1, 10)       // its the same 
				.mapToObj(x-> x)
				.collect(Collectors.toList());  */
	}

	public static void main(String[] args) {
		System.out.println("Map 2 Double : "+map2Double());
		System.out.println("Map 2 Long : "+map2Long());
		System.out.println("Map 2  : "+map2Object());

	}
	

}
