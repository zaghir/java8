package com.zaghir.projet.notionjava.feature.predicate;

import java.util.function.Predicate;

public class PredicateExample {

	public static void main(String[] args) {
		
		Predicate<Integer> lessThan = a -> (a <= 50) ;
		Predicate<Integer> greaterThan = a -> (a >= 100) ;
		Predicate<Integer> equalTo = a -> (a == 0) ;
		
		/*boolean result = lessThan.test(20) ;
		System.out.println("Result : " + result);*/
		
		
		System.out.println("less Than : "+greaterThan.test(100));
		System.out.println("Greater Than : "+greaterThan.test(100));
		System.out.println("Equal : "+greaterThan.test(0));

		System.out.println("========and()====================");
		boolean result1 = lessThan.and(greaterThan).and(equalTo).test(150) ;
		System.out.println("Result : "+result1);
		
		System.out.println("========or()====================");
		boolean result2 = lessThan.or(greaterThan).test(150) ;
		System.out.println("Result : "+result2);
		
		System.out.println("========negate()====================");
		boolean result3 = lessThan.or(greaterThan).negate().test(150) ;
		System.out.println("Result : "+result3);
	}

}
