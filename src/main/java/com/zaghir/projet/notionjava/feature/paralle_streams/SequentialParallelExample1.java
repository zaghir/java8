package com.zaghir.projet.notionjava.feature.paralle_streams;

import java.util.function.Supplier;
import java.util.stream.IntStream;

public class SequentialParallelExample1 {

	public static void main(String[] args) {
//		System.out.println("Sum from seq "+sumMethideusingSeq());
//		System.out.println("Sum from Parallel "+sumMethideusingSeq());
		
		System.out.println("Sum from seq "+checkPerformance(SequentialParallelExample1::sumMethodUsingSeq , 10000));
		System.out.println("Sum from Parallel "+checkPerformance(SequentialParallelExample1::sumMethodUsingParallel , 10000));
	}
	
	static long checkPerformance(Supplier<Integer> sum , int numOfTimes) {
		long start = System.currentTimeMillis();
		for(int i =0 ; i<= numOfTimes ; i++) {
			sum.get();
		}
		long end = System.currentTimeMillis();
		return end-start ;
	}
	
	static int sumMethodUsingSeq( ) {
		return IntStream.rangeClosed(1 ,  100000).sum() ;
	}

	
	static int sumMethodUsingParallel( ) {
		return IntStream.rangeClosed(1 ,  100000).parallel().sum() ;
	}

}
