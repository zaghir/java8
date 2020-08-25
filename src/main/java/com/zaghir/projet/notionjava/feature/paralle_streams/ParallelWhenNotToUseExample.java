package com.zaghir.projet.notionjava.feature.paralle_streams;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ParallelWhenNotToUseExample {

	public static void main(String[] args) {
		List<Integer> list = IntStream
				.rangeClosed(0, 10000)
				.boxed()    //  boxing  int to Integer
				.collect(Collectors.toList());
		sequentialCalculation(list);
		parallelCalculation(list);

	}
	
	static int sequentialCalculation(List<Integer> list) {
		long start = System.currentTimeMillis();
		int total =  list.stream()
				.reduce(0, (x,y) -> x+y) ;
		long end = System.currentTimeMillis();
		System.out.println("Sequential Duration : "+(end-start));
		return total ;
	}
	
	static int parallelCalculation(List<Integer> list) {
		long start = System.currentTimeMillis();
		int total =  list.parallelStream()  
				.reduce(0, (x,y) -> x+y) ;  // le retard du a l'execution de plusieurs threads on mode ecriture car en change la valeurs de reducer pour avoir la somme calculé , les thread ne sont pas efficace ne ecriture
		long end = System.currentTimeMillis();
		System.out.println("Parallel Duration : "+(end-start));
		return total ;
	}

}
