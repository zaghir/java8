package com.zaghir.projet.notionjava.feature.streams;

import java.util.Random;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

public class StreamFactoryMethodExample {

	
	static UnaryOperator<Integer> add = x -> x + 5 ;
	
	
	public static void main(String[] args) {
		
		Stream<Integer> s1 = Stream.iterate(0, add) ;
		s1.limit(10).forEach(System.out::println );
		
		// generate accept Supplier function 
		Stream<Double> s2 = Stream.generate(Math :: random).limit(10);
		//s2.forEach(System.out::println);
		
		Stream.generate(new Random()::nextInt).limit(10).forEach(System.out::println);

		System.out.println("==============================");
		Stream<String> s3 = Stream.of("One","Two" , "Tree" ,"Four") ;
		s3.forEach(System.out::println );
	}

}
